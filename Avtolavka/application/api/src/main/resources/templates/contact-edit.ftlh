<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <br>
    <br>
    <h1 class="my-3">Редактирование карточки контактного лица</h1>

    <div class="container">
        <a class="btn btn-primary" href="/clients/${form.clientId}">Отменить редактирование</a>
        <br>
        <br>
        <form action="/client-edit" method="post">
            <div class="row">
                <label class="flex flex-v-center">
                    <input type="text" name="id" value="${(form.id)!''}" hidden>
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Наименование:</span>
                    <input type="text" name="name" value="${(form.name)!''}">
                    <#if errors?? >
                        <#list errors as fieldError>
                            <#if fieldError.field == 'name'>
                                <p class="text-danger my-0">${fieldError.defaultMessage!'-- no message --'}</p>
                            </#if>
                        </#list>
                    </#if>
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Телефон:</span>
                    <input type="text" name="phone" value="${(form.phone)!''}">
                    <#if errors?? >
                        <#list errors as fieldError>
                            <#if fieldError.field == 'phone'>
                                <p class="text-danger my-0">${fieldError.defaultMessage!'-- no message --'}</p>
                            </#if>
                        </#list>
                    </#if>
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">E-mail:</span>
                    <input type="text" name="email" value="${(form.email)!''}">
                    <#if errors?? >
                        <#list errors as fieldError>
                            <#if fieldError.field == 'email'>
                                <p class="text-danger my-0">${fieldError.defaultMessage!'-- no message --'}</p>
                            </#if>
                        </#list>
                    </#if>
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Статус:</span>
                    <select name="status">
                        <option value="" hidden>Выберите статус</option>
                        <#if form.status=="Постоянный">
                            <option value="Постоянный" selected>Постоянный</option>
                            <option value="Новый">Новый</option>
                            <option value="Архивный">Архивный</option>
                        <#elseif form.status=="Новый">
                            <option value="Постоянный">Постоянный</option>
                            <option value="Новый" selected>Новый</option>
                            <option value="Архивный">Архивный</option>
                        <#elseif form.status=="Архивный">
                            <option value="Постоянный">Постоянный</option>
                            <option value="Новый">Новый</option>
                            <option value="Архивный" selected>Архивный</option>
                        </#if>
                    </select>
                </label>
            </div>
            <div class="mt-3">
                <button class="btn btn-primary" type="submit">Завершить</button>
            </div>
        </form>
    </div>
</@main.renderWith>