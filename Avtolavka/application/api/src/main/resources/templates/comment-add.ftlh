<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>
    <h1 class="my-3">Добавление комментария</h1>

    <div class="container">
    <a class="btn btn-secondary" href="/tasks/${taskId}">Отменить добавление</a>
    <br>
    <br>
    <form action="/comment-add" method="post">
    <div class="row">
        <label class="flex flex-v-center">
            <input type="text" name="taskId" value="${taskId}" hidden>
        </label>
    </div>
    <div class="row mt-2">
        <label class="flex flex-v-center">
            <span class="label-input-text mb-1">Комментарий:</span>
            <textarea class="form-control" name="description" v placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
            <#if errors?? >
                <#list errors as fieldError>
                    <#if fieldError.field == 'description'>
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