'use strict';
const server = "http://localhost:8500/api/"
makeRequest(0);

function setHandlers() {
    $('.page-item').click(function (){
        let pageNumber = $(this).find('.page-link').text();
        $('.page-item').removeClass('active');
        $(this).addClass('active');
        makeRequest(pageNumber - 1);
    })
}

function makeRequest(page) {
    $.ajax({
        method: "GET",
        url: server + "clients?page=" + page,
        success: (response) => {
            showPageLayout();
            showPageNavigator(response.totalPages, response.number);
            showClientsTable(response.content);
            setHandlers();
        },
        error: (error) => {
            console.log(error);
        }
    })
}

function showPageNavigator(totalPages, number) {
    for (let i = 1; i <= totalPages; i++) {
        if (number == i - 1) {
            $('.pagination').append($(`
                <li class="page-item active">
                    <span class="page-link">${i}</span>
                </li>
            `));
        } else {
            $('.pagination').append($(`
                <li class="page-item">
                    <span class="page-link">${i}</span>
                </li>
            `));
        }
    }
}

function showPageLayout() {
    let html = $(`
        <h1 class="my-3">Клиенты</h1>
        <a class="btn btn-primary" href="/clients/add">Создать клиента</a>
        <a class="btn btn-primary" href="/orders/add">Создать КП</a>
        <a class="btn btn-primary" href="/products/send-price">Отправить прайс</a>
        <br>
        <div class="container mb-3">
            <ul class="pagination justify-content-center"></ul>
            <table class="table table-hover mt-3">
                <thead class="table-light">
                <tr>
                    <th>Id клиента</th>
                    <th>Наименование</th>
                    <th>Краткое наименовние</th>
                    <th>Номер счета</th>
                    <th>Адрес</th>
                    <th>Телефон</th>
                    <th>E-mail</th>
                    <th>Статус</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
    `)
    $('#containerClients').empty();
    $('#containerClients').append(html);
}

function showClientsTable(clients) {
    $('tbody').empty();
    for (let i = 0; i < clients.length; i++) {
        $('tbody').append($(`
            <tr class="position-relative">
                <td>${clients[i].id}</td>
                <td>
                    <a href="/clients/${clients[i].id}" class="stretched-link" style="text-decoration: none; color: black">
                        ${clients[i].name}
                    </a>
                </td>
                <td>${clients[i].shortName}</td>
                <td>${clients[i].accountNumber}</td>
                <td>${clients[i].address}</td>
                <td>${clients[i].phoneMain}</td>
                <td>${clients[i].emailMain}</td>
                <td>${clients[i].status}</td>
            </tr>`));
    }
}