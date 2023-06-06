let rows = 8;
let board;
let other_boards = [];


function initializeTable() {
    rows = 4;
    board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [-4, 4, 6, -6], axis: true, showCopyright: false});
    for (let i = 1; i <= 5; i++) {
        let cur = JXG.JSXGraph.initBoard('jxgbox_' + i, {boundingbox: [-4, 4, 6, -6], axis: true, showCopyright: false});
        other_boards.push(cur);
    }
    checkRowLimits();
}

function setRowCount(count) {
    while (rows < count) {
        increment();
    }

    while (rows > count) {
        decrement();
    }
}


function checkRowLimits() {
    document.getElementById("row_num").innerHTML = rows;
    checkRemove()
    checkAdd()
}

function checkRemove() {
    if (rows === 4) {
        document.querySelector('#dec_btn').disabled = true;
        document.getElementById("dec_btn").classList.add("disabled_btn");
    }

    if (rows < 10) {
        document.querySelector('#inc_btn').disabled = false;
        document.getElementById("inc_btn").classList.remove("disabled_btn")
    }
}

function checkAdd() {
    if (rows === 10) {
        document.querySelector('#inc_btn').disabled = true;
        document.getElementById("inc_btn").classList.add("disabled_btn");
    }
    if (rows > 4) {
        document.querySelector('#dec_btn').disabled = false;
        document.getElementById("dec_btn").classList.remove("disabled_btn")
    }
}

function increment() {
    if (rows + 1 <= 10) {
        rows++;
        const str = '#row-' + rows;
        $(str).css('display', 'table-row');

    }
    checkRowLimits();
}

function decrement() {
    if (rows - 1 >= 4) {
        const str = '#row-' + rows;
        $(str).css('display', 'none');
        $(str + " input").val("")
        rows--;
    }
    checkRowLimits();
}

