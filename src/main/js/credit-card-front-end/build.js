var path = require('path');
var webpack = require('webpack');

var config =
{
    entry: './src/App.js',
    mode: 'development',
    output: {
        path: __dirname,
        filename: './../../resources/static/built/bundle.js'
    },
    module: {
        rules: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ["@babel/preset-env", "@babel/preset-react"]
                    }
                }]
            }
        ]
    }
};

function onComplete(error, stats)
{
    if(error)
    {
        console.error(error);
    }
    else
    {
        console.log(stats.toString());
    }
}

webpack(config, onComplete);