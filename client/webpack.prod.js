
 const webpack = require('webpack');
 const path = require('path');
 const HtmlWebpackPlugin = require('html-webpack-plugin');




 //require('jquery-validation');
 module.exports={
     context:path.join(__dirname,'src'),
     entry:'./index.js',
     output:{
         filename:'bundle.js',
         path:path.join(__dirname,'dist')
     },
     resolve: {

         extensions: ['.js', '.jsx'],
         alias: {
             service: path.resolve(__dirname, './src/app/service'),
             validatorFolder:path.resolve(__dirname, './src/app/validation'),
             routerPath:path.resolve(__dirname,'./src/app/util'),
             inputBuilderFolder:path.resolve(__dirname, './src/app/components/inputbuilder'),
             parentComponent:path.resolve(__dirname, './src/frontend/parent'),
             pagesPaths:path.resolve(__dirname,'./src/app/components/pages'),
             navigationPath:path.resolve(__dirname,'./src/app/components/navigation')
         },

     },
     module: {

         loaders: [{
             test: /\.js$/,
             exclude: /node_modules/,
             loaders: ['babel-loader',/*"eslint-loader"*/]

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


         new webpack.ProvidePlugin({
             $: 'jquery',
             jQuery: 'jquery',
             'window.$': 'jquery',
             'window.jQuery': 'jquery',
         }),
     new webpack.optimize.UglifyJsPlugin({
         include: /\.min\.js$/,
         minimize: true
     })
 ],

 };
