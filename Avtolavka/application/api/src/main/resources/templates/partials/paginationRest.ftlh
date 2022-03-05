<#macro pagination page link>
<#--    <#if 1 < page.totalPages>-->
        <ul class="pagination justify-content-center">
            <#list 1..page.totalPages as number>
                <#if page.number == number - 1>
                    <li class="page-item active">
<#--                        <a class="page-link" href="${link}page=${number-1}">${number}</a>-->
                        <span class="page-link">${number}</span>
                    </li>
                <#else>
                    <li class="page-item">
<#--                        <a class="page-link" href="${link}page=${number-1}">${number}</a>-->
                        <span class="page-link">${number}</span>
                    </li>
                </#if>
            </#list>
        </ul>
<#--    </#if>-->
</#macro>