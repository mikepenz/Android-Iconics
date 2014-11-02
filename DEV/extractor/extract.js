var fs = require('fs');

var PATTERN_KEY = /([^\.]+?)(?=:before { content: )/g;
var PATTERN_VALUE = /\\e(\d*|\w*)'/g;

fs.readFile("test.css", 'utf8', function(err, data) {
    match = PATTERN_KEY.exec(data);
    match2 = PATTERN_VALUE.exec(data);
    while (match != null) {
        var key = match[0];
        var value = match2[0];

        key = key.replace(/-/g, '_');
        value = value.replace(/\\e/g, '\\ue');

        console.log(key + "('" + value + "),");
        // matched text: match[0]
        // match start: match.index
        // capturing group n: match[n]
        match = PATTERN_KEY.exec(data);
        match2 = PATTERN_VALUE.exec(data);
    }
});