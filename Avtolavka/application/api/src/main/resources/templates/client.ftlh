<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <h1 class="my-3 pt-4">Информация о клиенте</h1>

    <div class="container">
        <a class="btn btn-primary" href="/clients">К списку клиентов</a>
        <a class="btn btn-primary" href="/clients/${client.id}/edit">Редактировать карточку</a>
        <a class="btn btn-primary" href="/clients/${client.id}/contacts/add">Добавить контакт</a>
        <br>
        <br>
        <div class="row flex-wrap">
            <div class="col-6">
                <h3>Информация о компании</h3>
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-4">
                                <p>Id: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.id}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Наименование: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.name}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Номер счета: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.accountNumber}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Адрес: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.address}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Телефон: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.phone}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>E-mail: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.email}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Статус: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.status}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Банк: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.bank}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <h3>Менеджеры компании</h3>
                <#list contacts as contact>
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${contact.name}</h5>
                            <div class="row">
                                <div class="col-9">
                                    <p class="card-text">
                                        Status: ${contact.status};
                                        Phone: ${contact.phone};
                                        E-mail: ${contact.email}<br>
                                    </p>
                                </div>
                                <div class="col-3">
                                    <a href="/contacts/${contact.id}/edit" class="btn btn-primary">Изменить</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</@main.renderWith>