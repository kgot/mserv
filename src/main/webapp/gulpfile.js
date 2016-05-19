var gulp = require('gulp');
var babel = require('gulp-babel');
var plumber = require('gulp-plumber');
var angularTemplateCache = require('gulp-angular-templatecache');
var uglify = require('gulp-uglify');
var concat = require('gulp-concat');
var rev = require('gulp-rev');
var revCollector = require('gulp-rev-collector');
var replace = require('gulp-replace');
var sourcemaps = require('gulp-sourcemaps');
//var gutil = require('gulp-util');
//var es = require('event-stream');
//var data = require('gulp-data');

var PRODUCTION = false;

var libs = {
  styled: [
    'public/components/angular/angular.js',
    'public/components/angular-animate/angular-animate.js',
    'public/components/angular-resource/angular-resource.js',
    'public/components/angular-route/angular-route.js',
    'public/components/angular-bootstrap/ui-bootstrap-tpls.js',
    'public/components/angular-smooth-scroll/angular-smooth-scroll.js'
  ],
  minified: [
    'public/components/angular/angular.min.js',
    'public/components/angular-animate/angular-animate.min.js',
    'public/components/angular-resource/angular-resource.min.js',
    'public/components/angular-route/angular-route.min.js',
    'public/components/angular-bootstrap/ui-bootstrap-tpls.min.js',
    'public/components/angular-smooth-scroll/angular-smooth-scroll.min.js'
  ]
};

var dist = {
  path: 'public/js/dist',
  files: [
    'public/js/dist/all.js',
    'public/js/dist/all.min.js',
    'public/js/dist/bundle.js',
    'public/js/dist/bundle.min.js'
  ]
};

// Anggular template cache configuration
// Path settings for Gulp
var config = {
  htmltemplates: 'public/templates/*.tpl.html',
  templateCache: {
    file: 'templates.tpl.js',
    options: {
      standalone: true,
      module: 'templates',
      moduleSystem: 'IIFE',
      transformUrl: function(url) {
        return url.replace(/\.tpl\.html$/, '.html');
      }
    }
  },
  dest: 'public/js/'
};

gulp.task('concat-libs', function() {
  return gulp.src(libs.styled)
    .pipe(plumber())
    .pipe(sourcemaps.init())
    .pipe(concat('bundle.js'))
    .pipe(sourcemaps.write('.'))
    .pipe(gulp.dest(dist.path));
});

gulp.task('concat-libs-min', function() {
  return gulp.src(libs.minified)
    .pipe(plumber())
    .pipe(sourcemaps.init())
    .pipe(concat('bundle.min.js'))
    .pipe(sourcemaps.write('.'))
    .pipe(gulp.dest(dist.path));
});

gulp.task('default', function() {
  return gulp.src('public/js/*.js')
    .pipe(plumber())
    .pipe(sourcemaps.init())
    .pipe(babel())
    .pipe(concat('all.js'))
    .pipe(sourcemaps.write('.'))
    .pipe(gulp.dest(dist.path));
});

gulp.task('default-min', function() {
  return gulp.src('public/js/*.js')
    .pipe(plumber())
    .pipe(sourcemaps.init())
    .pipe(babel())
    .pipe(concat('all.min.js'))
    .pipe(uglify())
    .pipe(sourcemaps.write('.'))
    .pipe(gulp.dest(dist.path));
});

gulp.task('cachebust', [PRODUCTION ? 'default-min' : 'default'], function() {
  return gulp.src(dist.files)
    .pipe(plumber())
    .pipe(rev())
    .pipe(gulp.dest(dist.path))
    .pipe(rev.manifest())
    .pipe(gulp.dest(dist.path));
});

gulp.task('cachebust-replace', ['cachebust'], function() {
  return gulp.src(['public/js/dist/rev-manifest.json', '././app/views/*.{html,php}'])
    .pipe(plumber())
    .pipe(revCollector())
    .pipe(gulp.dest('././app/views/'));
});

// Gulp task for creating template cache
gulp.task('templatecache', function() {
  return gulp.src(config.htmltemplates)
    .pipe(angularTemplateCache(
      config.templateCache.file,
      config.templateCache.options
    ))
    .pipe(gulp.dest(config.dest));
});

gulp.task('watch', function() {
  gulp.watch(['public/js/*.js', 'public/templates/*.html'], ['cachebust']);
});

gulp.task('watch-libs', function() {
  gulp.watch(['public/componnts/*.js'], [PRODUCTION ? 'concat-libs-min' : 'concat-libs-min']);
});
