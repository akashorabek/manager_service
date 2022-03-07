<#macro pagination page link>
    <ul class="pagination justify-content-center">
        <#list 1..page.totalPages as number>
            <#if page.number == number - 1>
                <li class="page-item active">
                    <span class="page-link">${number}</span>
                </li>
            <#else>
                <li class="page-item">
                    <span class="page-link">${number}</span>
                </li>
            </#if>
        </#list>
    </ul>
</#macro>