package com.smiling.gitapitest.bean;

import java.util.List;

/**
 * 作者：labbol
 * 时间：2019/01/24
 * 描述：URL_GIT_SEARCH_TOPICS返回实体类
 */
public class TopicsBean {


    /**
     * total_count : 8
     * incomplete_results : false
     * items : [{"name":"android","display_name":"Android","short_description":"Android is an operating system built by Google designed for mobile devices.","description":"Android was designed and built by Google in 2008. The operating system is written mainly in Java, with core components in C and C++. It is built on top of the Linux kernel, giving it incorporated security benefits.","created_by":"Google","released":"September 23, 2008","created_at":"2016-12-05T08:18:35Z","updated_at":"2019-01-24T12:52:03Z","featured":true,"curated":true,"score":4750.898},{"name":"java","display_name":"Java","short_description":"Java is an object-oriented programming language used mainly for desktop and mobile applications.","description":"Java was originally developed as an alternative to the C/C++ programming languages. It is now mainly used for building desktop, Android, and web server applications. Java is owned and licensed through Oracle.","created_by":"James Gosling","released":"May 23, 1995","created_at":"2016-12-14T21:15:34Z","updated_at":"2019-01-24T12:09:25Z","featured":true,"curated":true,"score":534.2464},{"name":"react-native","display_name":"React Native","short_description":"React Native is a JavaScript mobile framework developed by Facebook.","description":"React Native is a JavaScript mobile framework developed by Facebook. It allows developers to build Android and iOS mobile apps using JavaScript and reuse code across web and mobile applications.","created_by":"Facebook","released":"January 2015","created_at":"2017-01-31T21:11:16Z","updated_at":"2019-01-24T11:14:55Z","featured":true,"curated":true,"score":219.75772},{"name":"xamarin","display_name":"Xamarin","short_description":"Xamarin is a platform for developing iOS and Android applications.","description":"Xamarin is a Microsoft-owned, San Francisco, California-based software company. It was founded by the creators of Mono, Mono for Android, and MonoTouch, which are cross-platform implementations of the Common Language Infrastructure (CLI) and Common Language Specifications (often called Microsoft .NET).\n\nWith a C#-shared codebase, developers can use Xamarin tools to write native Android, iOS, and Windows apps. The apps have native user interfaces and share code across multiple platforms, including Windows and macOS.","created_by":"Miguel de Icaza, Nat Friedman","released":"May 16 2011","created_at":"2017-01-31T21:11:27Z","updated_at":"2019-01-24T10:55:40Z","featured":true,"curated":true,"score":211.00755},{"name":"kotlin","display_name":"Kotlin","short_description":"Kotlin is a statically typed programming language for multiplatform applications.","description":"Kotlin is a statically typed programming language for modern multiplatform applications. 100% interoperable with Java and Android, it now supports JavaScript and native with LLVM (including iOS). It was developed by JetBrains in 2011, and designed to be a new language for the Java Virtual Machine (JVM) that can compile quickly.","created_by":"JetBrains","released":"February 15, 2016","created_at":"2016-12-05T08:18:49Z","updated_at":"2019-01-24T12:37:22Z","featured":true,"curated":true,"score":170.70038},{"name":"nativescript","display_name":"NativeScript","short_description":"NativeScript is a JavaScript-native mobile framework.","description":"NativeScript is a JavaScript-native mobile framework developed by Progress. NativeScript allows developers to build truly native cross-platform iOS/Android mobile apps using existing web skills (JavaScript, CSS, XML) and established frameworks (Angular and Vue).","created_by":"Progress","released":"March 2015","created_at":"2017-02-01T10:30:48Z","updated_at":"2019-01-24T08:18:21Z","featured":true,"curated":true,"score":46.13551},{"name":"phaser","display_name":"Phaser","short_description":"Phaser is a fun, free, and fast 2D game framework for making HTML5 games for desktop and mobile web browsers.","description":"Phaser is a fast, free, and fun open source HTML5 game framework. It uses a custom build of Pixi.js for WebGL and Canvas rendering, and supports desktop and mobile web browsers. Games can be compiled to iOS, Android and native desktop apps via third party tools. You can use JavaScript or TypeScript for development.","created_by":"Richard Davey","released":null,"created_at":"2017-01-31T21:34:04Z","updated_at":"2019-01-24T09:51:13Z","featured":true,"curated":true,"score":43.59419},{"name":"mvvmcross","display_name":"MvvmCross","short_description":"The .NET MVVM framework for cross-platform solutions, including Xamarin.iOS, Xamarin.Android, Windows, and Mac.","description":"MvvmCross is a cross-platform model-view-view model framework that enables developers to create powerful, cross-platform mobile applications. It supports Xamarin.iOS, Xamarin.Android, Xamarin.Mac, Xamarin.Forms, Universal Windows Platform (UWP), and Windows Presentation Framework (WPF).","created_by":"Stuart Lodge","released":"June 2013","created_at":"2017-01-31T22:23:04Z","updated_at":"2019-01-22T06:40:25Z","featured":true,"curated":true,"score":31.105232}]
     */

    private int total_count;
    private boolean incomplete_results;
    private List<ItemsBean> items;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * name : android
         * display_name : Android
         * short_description : Android is an operating system built by Google designed for mobile devices.
         * description : Android was designed and built by Google in 2008. The operating system is written mainly in Java, with core components in C and C++. It is built on top of the Linux kernel, giving it incorporated security benefits.
         * created_by : Google
         * released : September 23, 2008
         * created_at : 2016-12-05T08:18:35Z
         * updated_at : 2019-01-24T12:52:03Z
         * featured : true
         * curated : true
         * score : 4750.898
         */

        private String name;
        private String display_name;
        private String short_description;
        private String description;
        private String created_by;
        private String released;
        private String created_at;
        private String updated_at;
        private boolean featured;
        private boolean curated;
        private double score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public String getShort_description() {
            return short_description;
        }

        public void setShort_description(String short_description) {
            this.short_description = short_description;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCreated_by() {
            return created_by;
        }

        public void setCreated_by(String created_by) {
            this.created_by = created_by;
        }

        public String getReleased() {
            return released;
        }

        public void setReleased(String released) {
            this.released = released;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public boolean isFeatured() {
            return featured;
        }

        public void setFeatured(boolean featured) {
            this.featured = featured;
        }

        public boolean isCurated() {
            return curated;
        }

        public void setCurated(boolean curated) {
            this.curated = curated;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }
}
