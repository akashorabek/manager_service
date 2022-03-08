'use strict';
const server = "http://localhost:8500/";
const serverApi = server + "api/";

requestBankNames();

function setHandlers() {
    showPhone2();
    showPhone3();
    selectMainPhone();
    showEmail2();
    showEmail3();
    selectMainEmail();
    sendAddClientRequest();
}

function main(response) {
    showPageLayout(response);
    setHandlers()
}

function sendAddClientRequest() {
    $('#addClientForm').submit(function(e) {
        e.preventDefault();
        e.stopPropagation();
        $('#phoneMain').val($('.phoneMain').val())
        $('#emailMain').val($('.emailMain').val())
        if ($('#name').val() == "") {
            alert('Заполните наименование');
            return;
        }
        if ($('#shortName').val() == "") {
            alert('Заполните краткое наименование');
            return;
        }
        if ($('#banksSelector').val() == "") {
            alert('Выберите банк');
            return;
        }
        $.ajax({
            method: "POST",
            url: serverApi + "clients/add",
            data: $('#addClientForm').serialize(),
            success: (response) => {
                window.location = server + "clients";
            },
            error: (error) => {
                alert(error)
            }
        })
    })
}

function showPhone2() {
    $('.phone1').find('.btnPhoneAdd').click(function () {
        $('.phone2').removeAttr('hidden');
        $(this).removeClass('btn');
        $(this).removeClass('btn-primary');
        $(this).empty();
    })
}

function showPhone3() {
    $('.phone2').find('.btnPhoneAdd').click(function () {
        $('.phone3').removeAttr('hidden');
        $(this).removeClass('btn');
        $(this).removeClass('btn-primary');
        $(this).empty();
    })
}

function selectMainPhone() {
    $('.phoneStatus').click(function () {
        $('.phoneStatus').find('span').text('Сделать основным');
        $('.phoneStatus').addClass('btn');
        $('.phoneStatus').addClass('btn-primary');
        $(this).find('span').text('Основной');
        $(this).removeClass('btn');
        $(this).removeClass('btn-primary');
        $('.phoneStatus').parent().find('input').removeClass('phoneMain');
        $(this).parent().find('input').addClass('phoneMain');
    })
}

function showEmail2() {
    $('.email1').find('.btnEmailAdd').click(function () {
        $('.email2').removeAttr('hidden');
        $(this).remove();
    })
}

function showEmail3() {
    $('.email2').find('.btnEmailAdd').click(function () {
        $('.email3').removeAttr('hidden');
        $(this).remove();
    })
}

function selectMainEmail() {
    $('.emailStatus').click(function () {
        $('.emailStatus').find('span').text('Сделать основным');
        $('.emailStatus').addClass('btn');
        $('.emailStatus').addClass('btn-primary');
        $(this).find('span').text('Основной');
        $(this).removeClass('btn');
        $(this).removeClass('btn-primary');
        $('.emailStatus').parent().find('input').removeClass('emailMain');
        $(this).parent().find('input').addClass('emailMain');
    })
}

function requestBankNames() {
    $.ajax({
        method: "GET",
        url: serverApi + "banks",
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
        <form id="addClientForm">
            <input type="text" name="phoneMain" id="phoneMain" hidden>
            <input type="text" name="emailMain" id="emailMain" hidden>
            <div class="row mt-2">
                <div class="col-3">
                    <span class="label-input-text mb-1">Наименование:</span>
                </div>
                <div class="col-9">
                    <input id="name" type="text" name="name" style="width: 100%">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-3">
                    <span class="label-input-text mb-1">Краткое наименование:</span>
                </div>
                <div class="col-9">
                    <input id="shortName" type="text" name="shortName" style="width: 100%">
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
                    <input class="phoneMain" type="text" name="phone1" style="width: 100%">
                </div>
                <div class="col-2 mx-5 phoneStatus">
                    <span>Основной</span>
                </div>
                <div class="col-1 btn btn-primary btnPhoneAdd">
                    <span>+ тел</span>
                </div>
            </div>
            <div class="row mt-2 phone2" hidden>
                <div class="col-3">
                    <span class="label-input-text mb-1">Телефон 2:</span>
                </div>
                <div class="col-3">
                    <input type="text" name="phone2" style="width: 100%">
                </div>
                <div class="col-2 mx-5 btn btn-primary phoneStatus">
                    <span>Сделать основным</span>
                </div>
                <div class="col-1 btn btn-primary btnPhoneAdd">
                    <span>+ тел</span>
                </div>
            </div>
            <div class="row mt-2 phone3" hidden>
                <div class="col-3">
                    <span class="label-input-text mb-1">Телефон 3:</span>
                </div>
                <div class="col-3">
                    <input type="text" name="phone3" style="width: 100%">
                </div>
                <div class="col-2 mx-5 btn btn-primary phoneStatus">
                    <span>Сделать основным</span>
                </div>
                <div class="col-1">
                </div>
            </div>
            <div class="row mt-2 email1">
                <div class="col-3">
                    <span class="label-input-text mb-1">E-mail 1:</span>
                </div>
                <div class="col-3">
                    <input class="emailMain" type="text" name="email1" style="width: 100%">
                </div>
                <div class="col-2 mx-5 emailStatus">
                    <span>Основной</span>
                </div>
                <div class="col-1 btn btn-primary btnEmailAdd">
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
                <div class="col-2 mx-5 btn btn-primary emailStatus">
                    <span>Основной</span>
                </div>
                <div class="col-1 btn btn-primary btnEmailAdd">
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
                <div class="col-2 mx-5 btn btn-primary emailStatus">
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