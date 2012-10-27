<!doctype html>
<html>
<head>
    <meta charset="utf-8">

    <title>Groovy Spring MVC Hibernate Template - <sitemesh:write property='title'/></title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="groovy, spring, hibernate, sitemesh, maven, bootstrap">

    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet">
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/js/google-code-prettify/prettify.css">

    <!--
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap-responsive.min.css" />
    -->
    <style type="text/css">
        body { padding-top: 60px; }
        ul { list-style-type: none; }
        .center {text-align: center;}
        #source { color: black; float: right; }
    </style>

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <!--
    <script type="text/javascript">window.jQuery || document.write('<script src="/static/js/jquery-1.7.2.min.js"><script>')</script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    -->

    <sitemesh:write property='head'/>

</head>
<body>

    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a href="/" class="brand">Groovy Spring Hibernate Template</a>
                <a href="https://github.com/kdabir/groovy-springmvc-sample" class="brand" id="source">Fork on GitHub</a>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="span8 offset2">
                <sitemesh:write property='body'/>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        var _gaq = _gaq || [];
        _gaq.push(['_setAccount', 'UA-5123395-7']);
        _gaq.push(['_trackPageview']);
        (function () {
            var ga = document.createElement('script');
            ga.type = 'text/javascript';
            ga.async = true;
            ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
            var s = document.getElementsByTagName('script')[0];
            s.parentNode.insertBefore(ga, s);
        })();
    </script>
</body>
</html>

