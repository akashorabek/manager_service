<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=["/css/clients.css"]>

    <br>
    <br>
    <h1 class="my-3">Информация о клиенте</h1>

    <div class="container">
        <a class="as-button rounded-2" href="/clients">К списку клиентов</a>
        <a class="as-button rounded-2" href="/clients/${client.id}/edit">Редактировать карточку</a>
        <br>
        <br>
        <div class="row">
            <div class="col-2">
                <p>Id: </p>
            </div>
            <div class="col-4">
                <p>${client.id}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <p>Наименование: </p>
            </div>
            <div class="col-4">
                <p>${client.name}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <p>Номер счета: </p>
            </div>
            <div class="col-4">
                <p>${client.accountNumber}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <p>Адрес: </p>
            </div>
            <div class="col-4">
                <p>${client.address}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <p>Телефон: </p>
            </div>
            <div class="col-4">
                <p>${client.phone}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <p>E-mail: </p>
            </div>
            <div class="col-4">
                <p>${client.email}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <p>Статус: </p>
            </div>
            <div class="col-4">
                <p>${client.status}</p>
            </div>
        </div>
    </div>
</@main.renderWith>