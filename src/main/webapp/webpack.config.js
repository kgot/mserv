var webpack = require('webpack');
var path = require('path');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

var BUILD_DIR = path.resolve(__dirname, 'js/build');
var APP_DIR = path.resolve(__dirname, 'js');
var STYLE_DIR = path.resolve(__dirname, 'css');

var config = {
  entry: [APP_DIR + '/app.js'],

  output: {
    path: BUILD_DIR,
    filename: 'bundle.js'
  },

  module: {
    loaders: [{
        test: /\.jsx?$/,
        include: APP_DIR,
        loader: 'babel',
        exclude: /node_modules/,
        query: {
          presets: ['react', 'es2015']
        }
      }, {
        test: /\.scss$/,
        loader: ExtractTextPlugin.extract('style', 'css!sass'),
        include: STYLE_DIR
      }
      // , { test: /\.jsx?$/, loader: 'jsx-loader' }
    ]
  },

  resolve: {
    extensions: ['', '.js', '.jsx', '.scss']
  },

  devtool: 'source-map',

  plugins: [
    new webpack.DefinePlugin({
      "process.env": {
        NODE_ENV: JSON.stringify('production')
      }
    }),
    new webpack.optimize.UglifyJsPlugin({
      mangle: {
        except: ['$super', '$', 'exports', 'require']
      }
    }),
    new ExtractTextPlugin('/style.css')
  ]
};

module.exports = config;
