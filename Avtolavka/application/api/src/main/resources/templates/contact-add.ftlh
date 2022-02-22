<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <br>
    <br>
    <h1 class="my-3">Добавление карточки контактного лица</h1>

    <div class="container">
        <a class="btn btn-primary" href="/clients/${clientId}">Отменить добавление</a>
        <br>
        <br>
        <form action="/contact-add" method="post">
            <div class="row">
                <label class="flex flex-v-center">
                    <input type="text" name="clientId" value="${clientId}" hidden>
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Полное имя:</span>
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
            <div class="mt-3">
                <button class="btn btn-primary" type="submit">Добавить</button>
            </div>
        </form>
    </div>
</@main.renderWith>