function getFunction(data) {
    switch (data.method) {
        case "linear":
            return x => data.approximationFunction[0] +
                data.approximationFunction[1] * x;
        case "square":
            return x => data.approximationFunction[0] +
                data.approximationFunction[1] * x +
                data.approximationFunction[2] * Math.pow(x, 2);
        case "cubic":
            return x => data.approximationFunction[0] +
                data.approximationFunction[1] * x +
                data.approximationFunction[2] * Math.pow(x, 2) +
                data.approximationFunction[3] * Math.pow(x, 3);
        case "exponential":
            return x => data.approximationFunction[0] * Math.exp(data.approximationFunction[1] * x);
        case "logarithmic":
            return x => data.approximationFunction[1] * Math.log(x) + data.approximationFunction[0];
        case "power":
            return x => data.approximationFunction[0] * Math.pow(x, data.approximationFunction[1])
    }
}

function getFunctionTextRepresentation(data) {
    switch (data.method) {
        case "linear":
            return data.approximationFunction[0].toFixed(2) + " + " +
                data.approximationFunction[1].toFixed(2) + "x";
        case "square":
            return data.approximationFunction[0].toFixed(2) + " + " +
                data.approximationFunction[1].toFixed(2) + "x + " +
                data.approximationFunction[2].toFixed(2) + "x ^ 2";
        case "cubic":
            return data.approximationFunction[0].toFixed(2) + " + " +
                data.approximationFunction[1].toFixed(2) + "x + " +
                data.approximationFunction[2].toFixed(2) + "x ^ 2 + " +
                data.approximationFunction[3].toFixed(2) + "x ^ 3";
        case "exponential":
            return data.approximationFunction[0].toFixed(2) +
                "e ^ (" + data.approximationFunction[1].toFixed(2) + "x)";
        case "logarithmic":
            return data.approximationFunction[1].toFixed(2) +
                "ln(x) + " + data.approximationFunction[0].toFixed(2);
        case "power":
            return data.approximationFunction[0].toFixed(2) +
                "x ^ " + data.approximationFunction[1].toFixed(2);
    }
}
