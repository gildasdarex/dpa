<div id="${fp.containerId}"
     style="${fp.containerVisibleStyle}${fp.containerStyle}">
      <g:set var="renderForm" value="${fp.customForm == false}"/>
      
      <g:if test="${renderForm}">
        <form name="${fp.formName}" id="${fp.formName}" method="${fp.formMethod}" action="${createLink(action: fp.formAction)}">
            <%-- Do we still need this hidden prop? --%>
              <input type="hidden" name="filterProperties" value="${fp.filterProperties}"/>
              <input type="hidden" name="listDistinct" value="${fp.listDistinct}"/>
              <input type="hidden" name="uniqueCountColumn" value="${fp.uniqueCountColumn}"/>


              <table cellspacing="0" cellpadding="0" class="table table-bordered">
                <g:each in="${fp.properties}" var="propMap">
                  <g:render plugin="filterpane" template="/_filterpane/filterpaneProperty" model="${propMap}"/>
                </g:each>
              </table>


              

              <g:if test="${fp.showButtons == true}">
                <g:render plugin="filterpane" template="/_filterpane/filterpaneButtons" model="${fp.buttonModel}" />
              </g:if>

       </form>
      </g:if>
</div>
