<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation Bar -->
<script type="text/javascript">
    var selected = '#${selectedNavbarItem.name()}';
    $(document).ready(function() {
        $(selected.toLowerCase()).addClass('active');
    });
</script>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Minion</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li id="servers">
                    <a href="/m/servers">
                        <span class="glyphicon glyphicon-hdd"></span> Servers
                    </a>
                </li>
                <li class="dropdown" id="network">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-random"></span> Network <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/m/network/dns"><span class="glyphicon glyphicon-list-alt"></span> DNS Records</a></li>
                        <li><a href="/m/network/certs"><span class="glyphicon glyphicon-link"></span> SSL Certificates</a></li>
                    </ul>
                </li>
                <li id="nimda">
                    <a href="/m/nimda">
                        <span class="glyphicon glyphicon-wrench"></span> Nimda
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
