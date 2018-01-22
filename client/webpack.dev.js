const webpack = require('webpack');
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');





module.exports={
    context:path.join(__dirname,'src'),
    entry:'./index.js',
    output:{
        filename:'bundle.js',
        path:path.join(__dirname,'dist')
    },


    devtool:'eval',
    devServer:{
        port:5600,
        proxy: {
            '*': "http://localhost:7070"
        },hot: true
    },

    resolve: {

        extensions: ['.js', '.jsx'],
        alias: {
            rootDirectory: path.resolve(__dirname, './src'),

        },

    },

    module: {

        loaders: [{
            test: /\.js$/,
            exclude: /node_modules/,
            loaders: ['babel-loader',"eslint-loader"]

        },
            {
                test: [/\.css$/,/\.scss$/],
                loaders: ["style-loader","css-loader","sass-loader"]
            },
            { test: /vendor\/.+\.(jsx|js)$/,
                loader: 'imports?jQuery=jquery,$=jquery,this=>window'
            },
            {
                test: require.resolve('jquery-validation'),
                loader: 'imports-loader',
                query: 'define=>false,$=jquery',
            },
            { test:/bootstrap-sass[\/\\]assets[\/\\]javascripts[\/\\]/, loader: 'imports?jQuery=jquery' }
        ],

    },

    plugins:[
        new HtmlWebpackPlugin({
            title:'Index',
            template:'./index.html'
        }),

        new webpack.NamedModulesPlugin(),
        new webpack.HotModuleReplacementPlugin(),
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery',
            'window.$': 'jquery',
            'window.jQuery': 'jquery',
        }),
    ],
    externals: {
        jquery: 'jQuery',
    }
};




