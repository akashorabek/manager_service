<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <h1 class="my-3 pt-4">Редактирование карточки клиента</h1>

    <div class="container">
        <a class="btn btn-primary" href="/clients">К списку клиентов</a>
        <a class="btn btn-primary" href="/clients/${form.id}">Отменить редактирование</a>
        <br>
        <br>
        <form action="/client-edit" method="post">
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
                    <span class="label-input-text mb-1">Номер счета:</span>
                    <input type="text" name="accountNumber" value="${(form.accountNumber)!''}">
                    <#if errors?? >
                        <#list errors as fieldError>
                            <#if fieldError.field == 'accountNumber'>
                                <p class="text-danger my-0">${fieldError.defaultMessage!'-- no message --'}</p>
                            </#if>
                        </#list>
                    </#if>
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Адрес:</span>
                    <input type="text" name="address" value="${(form.address)!''}">
                    <#if errors?? >
                        <#list errors as fieldError>
                            <#if fieldError.field == 'address'>
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
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Статус:</span>
                    <select name="status">
                        <option value="" hidden>Выберите статус</option>
                        <#if form.status=="Новый">
                            <option value="Новый" selected>Новый</option>
                            <option value="Постоянный">Постоянный</option>
                        <#elseif form.status=="Постоянный">
                            <option value="Новый">Новый</option>
                            <option value="Постоянный" selected>Постоянный</option>
                        <#else>
                            <option value="Новый">Новый</option>
                            <option value="Постоянный">Постоянный</option>
                        </#if>
                    </select>
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Банк:</span>
                    <select name="bank">
                        <option value="" hidden>Выберите банк</option>
                        <#list banks as bank>
                            <option value="${bank}" <#if form.bank==bank>selected</#if>>
                                ${bank.bankName}
                            </option>
                        </#list>
                    </select>
                </label>
            </div>
            <div class="mt-3">
                <button class="btn btn-primary" type="submit">Завершить</button>
            </div>
        </form>
    </div>
</@main.renderWith>