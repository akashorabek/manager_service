<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <h1 class="my-3">Информация о клиенте</h1>

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
                                <p>Краткое наименование: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.shortName}</p>
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
                                <p>Телефон основной: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.phoneMain}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Телефон 1: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.phone1}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Телефон 2: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.phone2}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Телефон 3: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.phone3}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>E-mail основной: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.emailMain}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>E-mail 1: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.email1}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>E-mail 2: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.email2}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>E-mail 3: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.email3}</p>
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
                                <p>Название банка: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.bank.bankName}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Адрес банк: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.bank.bankAddress}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>БИК: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.bank.bankBik}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>БИН: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.bank.bankBin}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <p>Номер счета: </p>
                            </div>
                            <div class="col-6">
                                <p>${client.bank.accountNumber}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <h3>Менеджеры компании</h3>
                <#list contacts as contact>
                    <div class="card mb-3" style="background-color:<#if contact.status == "Постоянный">rgba(40, 167, 69, .3);</#if><#if contact.status == "Архивный">rgba(108, 117, 125, .3);</#if><#if contact.status == "Новый">rgba(0, 123, 255, .3);</#if>">
                        <div class="card-body">
                            <h5 class="card-title">${contact.name}</h5>
                            <div class="row">
                                <div class="col-9">
                                    <p class="card-text">
                                        Status: ${contact.status}; <br>
                                        Job Position: ${contact.position}; <br>
                                        Phone: <#if contact.phone1??>${contact.phone1} <#else>Не указано</#if>; <br>
                                        <#if contact.phone2??><#if contact.phone2 != ''>Phone 2: ${contact.phone2}; <br></#if></#if>
                                        <#if contact.phone3??><#if contact.phone3 != ''>Phone 2: ${contact.phone3}; <br></#if></#if>
                                        E-mail: <#if contact.email1??>${contact.email1} <#else>Не указано</#if>; <br>
                                        <#if contact.email2??><#if contact.email2 != ''>E-mail 2: ${contact.email2}; <br></#if></#if>
                                        <#if contact.email3??><#if contact.email3 != ''>E-mail 3: ${contact.email3}; <br></#if></#if>

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