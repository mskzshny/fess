<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<tiles:useAttribute name="menuType" />
<div id="left">
	<h3>
		<bean:message key="labels.menu_system" />
	</h3>
	<p>
		<c:if test="${menuType=='wizard'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/wizard/index">
			<bean:message key="labels.menu.wizard" />
		</s:link>
		<c:if test="${menuType=='wizard'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='crawl'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/crawl/index">
			<bean:message key="labels.menu.crawl_config" />
		</s:link>
		<c:if test="${menuType=='crawl'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='system'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/system/index">
			<bean:message key="labels.menu.system_config" />
		</s:link>
		<c:if test="${menuType=='system'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='document'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/document/index">
			<bean:message key="labels.menu.document_config" />
		</s:link>
		<c:if test="${menuType=='document'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='scheduledJob'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/scheduledJob/index">
			<bean:message key="labels.menu.scheduled_job_config" />
		</s:link>
		<c:if test="${menuType=='scheduledJob'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='design'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/design/index">
			<bean:message key="labels.menu.design" />
		</s:link>
		<c:if test="${menuType=='design'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='dict'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/dict/index">
			<bean:message key="labels.menu.dict" />
		</s:link>
		<c:if test="${menuType=='dict'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='data'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/data/index">
			<bean:message key="labels.menu.data" />
		</s:link>
		<c:if test="${menuType=='data'}">
			</span>
		</c:if>
		<br />
	</p>
	<h3>
		<bean:message key="labels.menu_crawl" />
	</h3>
	<p>
		<c:if test="${menuType=='webCrawlingConfig'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/webCrawlingConfig/index">
			<bean:message key="labels.menu.web" />
		</s:link>
		<c:if test="${menuType=='webCrawlingConfig'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='fileCrawlingConfig'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/fileCrawlingConfig/index">
			<bean:message key="labels.menu.file_system" />
		</s:link>
		<c:if test="${menuType=='fileCrawlingConfig'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='dataCrawlingConfig'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/dataCrawlingConfig/index">
			<bean:message key="labels.menu.data_store" />
		</s:link>
		<c:if test="${menuType=='dataCrawlingConfig'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='labelType'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/labelType/index">
			<bean:message key="labels.menu.label_type" />
		</s:link>
		<c:if test="${menuType=='labelType'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='pathMapping'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/pathMapping/index">
			<bean:message key="labels.menu.path_mapping" />
		</s:link>
		<c:if test="${menuType=='pathMapping'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='webAuthentication'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/webAuthentication/index">
			<bean:message key="labels.menu.web_authentication" />
		</s:link>
		<c:if test="${menuType=='webAuthentication'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='fileAuthentication'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/fileAuthentication/index">
			<bean:message key="labels.menu.file_authentication" />
		</s:link>
		<c:if test="${menuType=='fileAuthentication'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='requestHeader'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/requestHeader/index">
			<bean:message key="labels.menu.request_header" />
		</s:link>
		<c:if test="${menuType=='requestHeader'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='overlappingHost'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/overlappingHost/index">
			<bean:message key="labels.menu.overlapping_host" />
		</s:link>
		<c:if test="${menuType=='overlappingHost'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='roleType'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/roleType/index">
			<bean:message key="labels.menu.role_type" />
		</s:link>
		<c:if test="${menuType=='roleType'}">
			</span>
		</c:if>
		<br />
	</p>
	<h3>
		<bean:message key="labels.menu_system_log" />
	</h3>
	<p>
		<c:if test="${menuType=='systemInfo'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/systemInfo/index">
			<bean:message key="labels.menu.system_info" />
		</s:link>
		<c:if test="${menuType=='systemInfo'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='jobLog'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/jobLog/index">
			<bean:message key="labels.menu.jobLog" />
		</s:link>
		<c:if test="${menuType=='jobLog'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='crawlingSession'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/crawlingSession/index">
			<bean:message key="labels.menu.session_info" />
		</s:link>
		<c:if test="${menuType=='crawlingSession'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='log'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/log/index">
			<bean:message key="labels.menu.log" />
		</s:link>
		<c:if test="${menuType=='log'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='failureUrl'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/failureUrl/index">
			<bean:message key="labels.menu.failure_url" />
		</s:link>
		<c:if test="${menuType=='failureUrl'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='searchList'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/searchList/index">
			<bean:message key="labels.menu.search_list" />
		</s:link>
		<c:if test="${menuType=='searchList'}">
			</span>
		</c:if>
		<br />
	</p>
	<h3>
		<bean:message key="labels.menu_user_log" />
	</h3>
	<p>
		<c:if test="${menuType=='searchLog'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/searchLog/index">
			<bean:message key="labels.menu.search_log" />
		</s:link>
		<c:if test="${menuType=='searchLog'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='stats'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/stats/index">
			<bean:message key="labels.menu.stats" />
		</s:link>
		<c:if test="${menuType=='stats'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='userInfo'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/userInfo/index">
			<bean:message key="labels.menu.user" />
		</s:link>
		<c:if test="${menuType=='userInfo'}">
			</span>
		</c:if>
		<br />
		<c:if test="${menuType=='favoriteLog'}">
			<span class="selected">
		</c:if>
		<s:link href="${contextPath}/admin/favoriteLog/index">
			<bean:message key="labels.menu.favoriteLog" />
		</s:link>
		<c:if test="${menuType=='favoriteLog'}">
			</span>
		</c:if>
		<br />
	</p>
</div>
