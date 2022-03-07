'use strict';
const server = "http://localhost:8500/api/";
requestBankNames();

function main(response) {
    showPageLayout(response);
    setHandlers()
}

function setHandlers () {
    $('.phone1').find('.btnPhoneAdd').click(function () {
        $('.phone2').removeAttr('hidden');
        $(this).removeClass('btn');
        $(this).removeClass('btn-primary');
        $(this).empty();
    })
    $('.phone2').find('.btnPhoneAdd').click(function () {
        $('.phone3').removeAttr('hidden');
        $(this).removeClass('btn');
        $(this).removeClass('btn-primary');
        $(this).empty();
    })
    $('.phoneStatus').click(function () {
        $('.phoneStatus').find('span').text('Сделать основным');
        $('.phoneStatus').addClass('btn');
        $('.phoneStatus').addClass('btn-primary');
        $(this).find('span').text('Основной');
        $(this).removeClass('btn');
        $(this).removeClass('btn-primary');
    })
    $('.email1').find('.btn').click(function () {
        $('.email2').removeAttr('hidden');
        $(this).remove();
    })
    $('.email2').find('.btn').click(function () {
        $('.email3').removeAttr('hidden');
        $(this).remove();
    })
}

function requestBankNames() {
    $.ajax({
        method: "GET",
        url: server + "banks",
        success: (response) => {
            main(response);
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
        <form>
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
            <div class="row mt-2 phone1">
                <div class="col-3">
                    <span class="label-input-text mb-1">Телефон 1:</span>
                </div>
                <div class="col-3">
                    <input type="text" name="phone1" style="width: 100%">
                </div>
                <div class="col-1 btn btn-primary btnPhoneAdd">
                    <span>+ тел</span>
                </div>
                <div class="col-2 mx-5 phoneStatus">
                    <span>Основной</span>
                </div>
            </div>
            <div class="row mt-2 phone2" hidden>
                <div class="col-3">
                    <span class="label-input-text mb-1">Телефон 2:</span>
                </div>
                <div class="col-3">
                    <input type="text" name="phone2" style="width: 100%">
                </div>
                <div class="col-1 btn btn-primary btnPhoneAdd">
                    <span>+ тел</span>
                </div>
                <div class="col-2 mx-5 btn btn-primary phoneStatus">
                    <span>Сделать основным</span>
                </div>
            </div>
            <div class="row mt-2 phone3" hidden>
                <div class="col-3">
                    <span class="label-input-text mb-1">Телефон 3:</span>
                </div>
                <div class="col-3">
                    <input type="text" name="phone3" style="width: 100%">
                </div>
                <div class="col-1">
                </div>
                <div class="col-2 mx-5 btn btn-primary phoneStatus">
                    <span>Сделать основным</span>
                </div>
            </div>
            <div class="row mt-2 email1">
                <div class="col-3">
                    <span class="label-input-text mb-1">E-mail 1:</span>
                </div>
                <div class="col-3">
                    <input type="text" name="email1" style="width: 100%">
                </div>
                <div class="col-2">
                    <span>Основной</span>
                </div>
                <div class="col-1 btn btn-primary">
                    <span>+ email</span>
                </div>
            </div>
            <div class="row mt-2 email2" hidden>
                <div class="col-3">
                    <span class="label-input-text mb-1">E-mail 2:</span>
                </div>
                <div class="col-3">
                    <input type="text" name="email2" style="width: 100%">
                </div>
                <div class="col-2">
                    <span>Основной</span>
                </div>
                <div class="col-1 btn btn-primary">
                    <span>+ email</span>
                </div>
            </div>
            <div class="row mt-2 email3" hidden>
                <div class="col-3">
                    <span class="label-input-text mb-1">E-mail 3:</span>
                </div>
                <div class="col-3">
                    <input type="text" name="email3" style="width: 100%">
                </div>
                <div class="col-2">
                    <span>Основной</span>
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