<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <h1 class="my-3">Редактирование задачи</h1>

    <div class="container">
        <a class="btn btn-secondary" href="/tasks/${form.id}">Отменить редактирование</a>
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
            <div class="row mt-2" hidden>
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Дата создания :</span>
                    <input type="date" name="createDate" value="${(form.createDate)!''}">
                    <#if errors?? >
                        <#list errors as fieldError>
                            <#if fieldError.field == 'createDate'>
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
                    <span class="label-input-text mb-1">Приоритет:</span>
                    <select name="status">
                        <option value="" hidden>Выберите приоритетность: </option>
                        <#if form.status=="Текущий">
                            <option value="Текущий" selected>Текущий</option>
                            <option value="Средний">Средний</option>
                            <option value="Высокий">Высокий</option>
                        <#elseif form.status=="Средний">
                            <option value="Текущий">Текущий</option>
                            <option value="Средний" selected>Средний</option>
                            <option value="Высокий">Высокий</option>
                        <#elseif form.status=="Высокий">
                            <option value="Текущий">Текущий</option>
                            <option value="Средний">Средний</option>
                            <option value="Высокий" selected>Высокий</option>
                        </#if>
                    </select>
                </label>
            </div>
            <div class="mt-3">
                <button class="btn btn-secondary" type="submit">Редактировать</button>
            </div>
        </form>
    </div>

</@main.renderWith>