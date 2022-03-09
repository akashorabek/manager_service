<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <h1 class="my-3">Информация о задаче</h1>


    <div class="container">
    <a class="btn btn-secondary" href="/">К списку задач</a>
    <a class="btn btn-secondary" href="/tasks/${task.id}/edit">Редактировать задачу</a>
    <br>
    <br>

        <div class="row flex-wrap">
            <div class="col-6">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-4">
                                <p>Наименование: </p>
                            </div>
                            <div class="col-6">
                                <p>${task.name}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Описание: </p>
                            </div>
                            <div class="col-6">
                                <p>${task.description}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Дата создания: </p>
                            </div>
                            <div class="col-6">
                                <p>${task.createDate}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Срок выполнения: </p>
                            </div>
                            <div class="col-6">
                                <p>${task.deadline}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Приоритет: </p>
                            </div>
                            <div class="col-6">
                                <p>${task.status}</p>
                            </div>
                        </div>
                        <#if tasks??>
                        <div class="row">
                            <div class="col-4">
                                <p>Дата закрытия: </p>
                            </div>
                            <div class="col-6">
                                <p>${task.finish}</p>
                            </div>
                        </div>
        </#if>

        <a class="btn btn-secondary" href="/tasks/${task.id}/execute">В работу</a>
        <a class="btn btn-secondary" href="/tasks/${task.id}/comments/add">Комментировать</a>

    </div>

    </div>
    </div>
            <div class="col-6">
                <h3>Комментарии: </h3>
                <#list comments as comment>
                    <div class="card mb-3" >
                        <div class="card-body">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-9">
                                        <p class="card-text">
                            ${comment.description}
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
    </div>

    </div>
</@main.renderWith>