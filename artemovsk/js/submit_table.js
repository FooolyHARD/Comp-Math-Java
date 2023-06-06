function submitForm(event) {

    const inputs1 = document.getElementsByTagName('input');
    document.getElementById('error_label').textContent = ''
    let error = false;
    let errorText = "";
    let set = new Set();


    for (let i = 0; i < rows * 2; i++) {
        const val = parseFloat(inputs1[i].value);
        if (isNaN(val) || val < -10000 || val > 10000) {

            inputs1[i].classList.add('error');
            error = true;
            errorText = 'Доступен диапазон [-10000; 10000]';

        } else {
            inputs1[i].classList.remove('error');
            if (set.has(val) && i % 2 === 0) {
                for (j = 0; j < rows * 2; j += 2) {

                    const new_val = parseFloat(inputs1[j].value);

                    if (new_val === val) {
                        inputs1[j].classList.add('error');
                        errorText = 'Нельзя ставить одинаковые значения';
                    }

                }
                error = true;
            }
            if (i % 2 === 0){
                set.add(val);
            }
        }
    }
    if (error) {
        document.getElementById('error_label').textContent = errorText
        return;
    }


    event.preventDefault();
    const form = document.querySelector('form');
    const inputs = Array.from(form.querySelectorAll('input[type="number"]'));
    const values = inputs.map(input => parseFloat(input.value));

    let points = parseTable(values);

    console.log(JSON.stringify(points))

    $.ajax({
        type: 'POST',
        url: backendUrl + "/api/submit",
        contentType: "application/json",
        data: JSON.stringify(points),
        dataType: 'json',
        success: (data) => {
            let min_x = points[0].x;
            let max_x = points[0].x;

            let min_y = points[0].y;
            let max_y = points[0].y;

            points.forEach((point) => {
                min_x = Math.min(min_x, point.x);
                max_x = Math.max(max_x, point.x);

                min_y = Math.min(min_y, point.y);
                max_y = Math.max(max_y, point.y);
            });

            board = initBoard(min_x, max_x, min_y, max_y, 'jxgbox', board, data, points);

            $("#result").html('Метод: ' + data.method);
            $("#function").html('f(x): ' + getFunctionTextRepresentation(data));
            $('#standard_deviation').html('Отклонение: ' + data.standardDeviation.toFixed(5))
            $('#phis').html('Фи: ' + data.phiList.map(e => e.toFixed(5)).join(' '))
            $('#epsilons').html('Эпсилон: ' + data.epsilonList.map(e => e.toFixed(5)).join(' '))
            $('#pirson').html('Кэф пирса: ' + data.pirsonCoefficient.toFixed(5))
            processGraphs(data.notBestApproximations, min_x, max_x, min_y, max_y, points)
        },
        error: (error) => {
            document.getElementById('error_label').textContent = "Error during communicating with backend"
        }
    });
}

function initBoard(min_x, max_x, min_y, max_y, boardId, boardObj, data, points) {
    boardObj = JXG.JSXGraph.initBoard(boardId, {
        boundingbox: [min_x - 2, max_y + 2, max_x + 2, min_y - 2],
        axis: true,
        showCopyright: false
    });

    boardObj.create('functiongraph', [getFunction(data)]);

    draw_points(boardObj, points);

    return boardObj;
}

function processGraphs(methodResults, min_x, max_x, min_y, max_y, points) {
    for (let i = 1; i <= 5; i++) {
        let data = methodResults[i - 1];
        if (data.approximationFunction.length === 0) {
            $('#result_' + i).html('Метод: ' + data.method);
            $('#function_' + i).html('Не сработало');
            $('#standard_deviation_' + i).html('')
            $('#phis_' + i).html('')
            $('#epsilons_' + i).html('')
            $('#pirson_' + i).html('')
        } else {
            $('#result_' + i).html('Метод: ' + data.method);
            $('#function_' + i).html('f(x): ' + getFunctionTextRepresentation(data));
            $('#standard_deviation_' + i).html('Отклонение: ' + data.standardDeviation.toFixed(5))
            $('#phis_' + i).html('ФИ: ' + data.phiList.map(e => e.toFixed(5)).join(' '))
            $('#epsilons_' + i).html('ЭПСИЛО): ' + data.epsilonList.map(e => e.toFixed(5)).join(' '))
            $('#pirson_' + i).html('Кэф пирсона: ' + data.pirsonCoefficient.toFixed(5))
        }
        other_boards[i - 1] = initBoard(min_x, max_x, min_y, max_y, 'jxgbox_' + i, other_boards[i - 1], data, points)
    }
}



