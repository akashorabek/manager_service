<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <h1 class="my-3">Редактирование задачи</h1>

    <div class="container">
        <br>
        <form action="/task-edit" method="post">
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
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Сратус:</span>
                    <input type="text" name="status" value="${(form.status)!''}">
                    <#if errors?? >
                        <#list errors as fieldError>
                            <#if fieldError.field == 'status'>
                                <p class="text-danger my-0">${fieldError.defaultMessage!'-- no message --'}</p>
                            </#if>
                        </#list>
                    </#if>
                </label>
            </div>
            <div class="mt-3">
                <button class="btn btn-primary" type="submit">Завершить</button>
            </div>
        </form>
    </div>

</@main.renderWith>