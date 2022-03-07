<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>
    <h1 class="my-3">Добавление новой задачи</h1>

    <div class="container">
    <a class="btn btn-secondary" href="/">Отменить добавление</a>
    <br>
    <br>
    <form action="/task-add" method="post">
    <div class="row mt-2">
        <label class="flex flex-v-center">
            <span class="label-input-text mb-1">Заголовок:</span>
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
            <span class="label-input-text mb-1">Описание:</span>
            <input type="text" name="description" value="${(form.description)!''}">
            <#if errors?? >
                <#list errors as fieldError>
                    <#if fieldError.field == 'description'>
                        <p class="text-danger my-0">${fieldError.defaultMessage!'-- no message --'}</p>
                    </#if>
                </#list>
            </#if>
        </label>
    </div>
    <div class="row mt-2">
        <label class="flex flex-v-center">
            <span class="label-input-text mb-1">Срок выполнения:</span>
            <input type="date" name="deadline" value="${(form.deadline)!''}">
            <#if errors?? >
                <#list errors as fieldError>
                    <#if fieldError.field == 'deadline'>
                        <p class="text-danger my-0">${fieldError.defaultMessage!'-- no message --'}</p>
                    </#if>
                </#list>
            </#if>
        </label>
    </div>
        <div class="mt-3">
            <button class="btn btn-secondary" type="submit">Добавить</button>
        </div>
    </form>
    </div>

</@main.renderWith>