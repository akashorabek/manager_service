'use strict';
const server = "http://localhost:8500/api/";
requestBankNames();

function showClientsTable(data) {
    console.log(data);
}

function requestBankNames() {
    $.ajax({
        method: "GET",
        url: server + "banks",
        success: (response) => {
            showPageLayout(response);
        },
        error: (error) => {
            console.log(error);
        }
    })
}

function showPageLayout(banks) {
    let html = $(`
        <h1 class="my-3">Добавление карточки клиента</h1>
        <a class="btn btn-primary" href="/clients">Отменить добавление</a>
        <br>
        <form action="/client-add" method="post">
            <div class="row mt-2">
                <div class="col-3">
                    <span class="label-input-text mb-1">Наименование:</span>
                </div>
                <div class="col-9">
                    <input type="text" name="name" style="width: 100%">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-3">
                    <span class="label-input-text mb-1">Краткое наименование:</span>
                </div>
                <div class="col-9">
                    <input type="text" name="shortName" style="width: 100%">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-3">
                    <span class="label-input-text mb-1">Номер счета:</span>
                </div>
                <div class="col-9">
                    <input type="text" name="accountNumber" style="width: 100%">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-3">
                    <span class="label-input-text mb-1">Адрес:</span>
                </div>
                <div class="col-9">
                    <input type="text" name="address" style="width: 100%">
                </div>                
            </div>
            <div class="row mt-2">
                <div class="col-3">
                    <span class="label-input-text mb-1">Телефон 1:</span>
                </div>
                <div class="col-3">
                    <input type="text" name="phone1" style="width: 100%">
                </div>
                <div class="col-2">
                    <span>Основной</span>
                </div>
                <div class="col-2">
                    <span>Добавить телефон</span>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-3">
                    <span class="label-input-text mb-1">Телефон 2:</span>
                </div>
                <div class="col-3">
                    <input type="text" name="phone2" style="width: 100%">
                </div>
                <div class="col-2">
                    <span>Основной</span>
                </div>
                <div class="col-2">
                    <span>Добавить телефон</span>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-3">
                    <span class="label-input-text mb-1">Телефон 3:</span>
                </div>
                <div class="col-3">
                    <input type="text" name="phone3" style="width: 100%">
                </div>
                <div class="col-2">
                    <span>Основной</span>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-3">
                    <span class="label-input-text mb-1">E-mail 1:</span>
                </div>
                <div class="col-9">
                    <input type="text" name="email1" style="width: 50%">
                </div>
            </div>
            <div class="row mt-2" hidden>
                <div class="col-3">
                    <span class="label-input-text mb-1">E-mail 2:</span>
                </div>
                <div class="col-9">
                    <input type="text" name="email2" style="width: 50%">
                </div>
            </div>
            <div class="row mt-2" hidden>
                <div class="col-3">
                    <span class="label-input-text mb-1">E-mail 3:</span>
                </div>
                <div class="col-9">
                    <input type="text" name="email3" style="width: 50%">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-3">
                    <span class="label-input-text mb-1">Банк:</span>
                </div>
                <div class="col-9">
                    <select id="banksSelector" name="bank">
                        <option value="" hidden>Выберите банк</option>
                    </select>
                </div>
            </div>
            <div class="mt-3">
                <button class="btn btn-primary" type="submit">Добавить</button>
            </div>
        </form>
        
    `)
    $('#containerClientAdd').append(html)
    addBanks(banks);
}

function addBanks(banks) {
    for (let i = 0; i < banks.length; i++) {
        $('#banksSelector').append($(`
            <option value="${banks[i]}">${banks[i]}</option>
        `));
    }
}