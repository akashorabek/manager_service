<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <h1 class="my-3">Информация о задаче</h1>


    <div class="container">
    <a class="btn btn-primary" href="/tasks">К списку задач</a>
    <a class="btn btn-primary" href="/tasks/${task.id}/edit">Редактировать задачу</a>
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
            <p>Статус: </p>
        </div>
        <div class="col-6">
            <p>${task.status}</p>
        </div>
    </div>
    </div>
    </div>
    </div>
    </div>
    </div>
</@main.renderWith>