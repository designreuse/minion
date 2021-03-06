<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-3 main">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <form:form cssClass="form-horizontal" role="form" method="POST" action="/m/servers/create">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Hostname</label>
                            <div class="col-sm-3">
                                <form:input path="hostname" cssClass="form-control" maxlength="16" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Domain</label>
                            <div class="col-sm-3">
                                <form:select path="domainId" cssClass="form-control" items="${domains}" itemValue="domainId" itemLabel="domainName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">IP Address</label>
                            <div class="col-sm-3">
                                <form:input path="ipAddress" cssClass="form-control" maxlength="16" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Data Center</label>
                            <div class="col-sm-3">
                                <form:select path="dataCenterId" cssClass="form-control" items="${dataCenters}" itemValue="dataCenterId" itemLabel="dataCenterName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Server Type</label>
                            <div class="col-sm-2">
                                <form:select path="serverTypeId" cssClass="form-control" items="${serverTypes}" itemValue="typeId" itemLabel="typeCode"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Operating System</label>
                            <div class="col-sm-3">
                                <form:select path="operatingSystemId" cssClass="form-control" items="${operatingSystems}" itemValue="operatingSystemId" itemLabel="operatingSystemName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9 text-left">
                                <button type="submit" class="btn btn-success">Create Server</button>
                                <a href="/m/servers" class="btn btn-default">Cancel</a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>

        </div>

    </div>

</div>

<%@include file="/WEB-INF/jsp/includes/footer.jsp" %>