<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <h1 class="my-3 pt-4">Добавление карточки клиента</h1>

    <div class="container">
        <a class="btn btn-primary" href="/clients">Отменить добавление</a>
        <br>
        <br>
        <form action="/client-add" method="post">
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
                    <span class="label-input-text mb-1">Краткое наименование:</span>
                    <input type="text" name="shortName" value="${(form.shortName)!''}">
                    <#if errors?? >
                        <#list errors as fieldError>
                            <#if fieldError.field == 'shortName'>
                                <p class="text-danger my-0">${fieldError.defaultMessage!'-- no message --'}</p>
                            </#if>
                        </#list>
                    </#if>
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Номер счета:</span>
                    <input type="text" name="accountNumber" value="${(form.accountNumber)!''}">
                    <#if errors?? >
                        <#list errors as fieldError>
                            <#if fieldError.field == 'accountNumber'>
                                <p class="text-danger my-0">${fieldError.defaultMessage!'-- no message --'}</p>
                            </#if>
                        </#list>
                    </#if>
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Адрес:</span>
                    <input type="text" name="address" value="${(form.address)!''}">
                    <#if errors?? >
                        <#list errors as fieldError>
                            <#if fieldError.field == 'address'>
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
            <div class="mt-3">
                <button class="btn btn-primary" type="submit">Добавить</button>
            </div>
        </form>
    </div>
</@main.renderWith>