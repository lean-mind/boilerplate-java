const path = require('path');

module.exports = {
  devtool: 'source-map',
  mode: 'development',
  entry: {
    'user': './userApp/App.tsx',
  },
  resolve: {
    // Add '.ts' and '.tsx' as resolvable extensions.
    extensions: [".ts", ".tsx", ".js"]
  },
  output: {
    path: path.resolve(__dirname, '../resources/static/dist'),
    filename: '[name]-bundle.js'
  },
  module: {
    rules: [
      { test: /\.tsx?$/, loader: "ts-loader" }
    ]
  }
};