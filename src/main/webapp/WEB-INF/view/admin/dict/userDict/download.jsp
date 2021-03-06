<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%><tiles:insert template="/WEB-INF/view/common/admin/layout.jsp"
	flush="true">
	<tiles:put name="title">
		<bean:message key="labels.dict_userdict_configuration" />
	</tiles:put>
	<tiles:put name="header" value="/WEB-INF/view/common/admin/header.jsp" />
	<tiles:put name="footer" value="/WEB-INF/view/common/admin/footer.jsp" />
	<tiles:put name="menu" value="/WEB-INF/view/common/admin/menu.jsp" />
	<tiles:put name="menuType" value="dict" />
	<tiles:put name="headerScript" type="string"></tiles:put>
	<tiles:put name="body" type="string">

		<h3>
			<bean:message key="labels.dict_userdict_title" />
		</h3>

		<%-- Message: BEGIN --%>
		<div>
			<html:messages id="msg" message="true">
				<div class="alert-message info"><bean:write name="msg" ignore="true" /></div>
			</html:messages>
			<html:errors />
		</div>
		<%-- Message: END --%>

			<div>
				<ul class="pills">
					<li><s:link href="../index">
							<bean:message key="labels.dict_list_link" />
						</s:link></li>
					<li><s:link href="index?dictId=${f:u(dictId)}">
							<bean:message key="labels.dict_userdict_list_link" />
						</s:link></li>
					<li><s:link href="createpage?dictId=${f:u(dictId)}">
							<bean:message key="labels.dict_userdict_link_create" />
						</s:link></li>
					<li class="active"><a href="#">
							<bean:message key="labels.dict_userdict_link_download" />
						</a></li>
					<li><s:link href="uploadpage?dictId=${f:u(dictId)}">
							<bean:message key="labels.dict_userdict_link_upload" />
						</s:link></li>
				</ul>
			</div>

		<%-- Edit Form: BEGIN --%>
		<s:form>
			<div>
				<html:hidden property="dictId" />
				<table class="bordered-table zebra-striped" style="width: 500px;">
					<tbody>
						<tr>
							<th style="vertical-align: middle;">${f:h(filename)}</th>
							<td style="width: 150px;text-align: center;"><input type="submit"
								class="btn small" name="download"
								value="<bean:message key="labels.dict_userdict_button_download"/>" />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</s:form>
		<%-- Edit Form: BEGIN --%>

	</tiles:put>
</tiles:insert>
