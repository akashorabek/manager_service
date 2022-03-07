'use strict';
const server = "http://localhost:8500/api/";
const blank = "";
showPageLayout();

function showPageLayout() {
    let html = $(`
        <h1 class="my-3">Добавление карточки клиента</h1>
        <a class="btn btn-primary" href="/clients">Отменить добавление</a>
        <br>
        <form action="/client-add" method="post">
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Наименование:</span>
                    <input type="text" name="name">
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Краткое наименование:</span>
                    <input type="text" name="shortName">
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Номер счета:</span>
                    <input type="text" name="accountNumber">
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Адрес:</span>
                    <input type="text" name="address">
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Телефон:</span>
                    <input type="text" name="phone">
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">E-mail:</span>
                    <input type="text" name="email">
                </label>
            </div>
            <div class="row mt-2">
                <label class="flex flex-v-center">
                    <span class="label-input-text mb-1">Банк:</span>
                    <select name="bank">
                        <option value="" hidden>Выберите банк</option>
                    </select>
                </label>

            </div>
            <div class="mt-3">
                <button class="btn btn-primary" type="submit">Добавить</button>
            </div>
        </form>
        
    `)
    $('#containerClientAdd').append(html)
}
