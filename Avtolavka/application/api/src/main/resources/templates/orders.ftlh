<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=["/css/clients.css"]>

<main class="mainContainer">
    <div class="container">
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-1 g-4 bg-light">
        <div class="col num_1">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h2 class="title_order">Заявка (КП) №1</h2>
                    <p class="card-text">Имя клиента: клиент №1</p>
                    <p class="card-text">Номер телефона: 555</p>
                    <p class="card-text">Email: example@gmail.com</p>
                    <p class="card-text">Наименование товара: Свеча зажигания</p>
                    <p class="card-text">Уникальный номер товара: 7700 500 168</p>
                    <p class="card-text">Цена товара: 1 100 тг</p>
                </div>
            </div>
            <div class="col num_2">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h2 class="title_order">Заявка (КП) №2</h2>
                        <p class="card-text">Имя клиента: клиент №2</p>
                        <p class="card-text">Номер телефона: 777</p>
                        <p class="card-text">Email: example@mail.ru</p>
                        <p class="card-text">Наименование товара: Фильтр масляный</p>
                        <p class="card-text">Уникальный номер товара: 06A 115 561 B</p>
                        <p class="card-text">Цена товара: 2 040 тг</p>
                    </div>
                </div>
            </div>
            <div class="col num_3">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h2 class="title_order">Заявка (КП) №3</h2>
                        <p class="card-text">Имя клиента: клиент №3</p>
                        <p class="card-text">Номер телефона: 222</p>
                        <p class="card-text">Email: example@mail.ru</p>
                        <p class="card-text">Наименование товара: Ремень гидроусилителя</p>
                        <p class="card-text">Уникальный номер товара: MD 304887</p>
                        <p class="card-text">Цена товара: 9 120 тг</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <a class="page-link" href="#" tabindex="-1">Назад</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#">Вперёд</a>
                </li>
            </ul>
        </nav>
    </div>
</main>
<footer class="text-muted py-5">
    <div class="container">
        <p class="float-end mb-1">
            <a href="#">Вернуться наверх</a>
        </p>
        <h3 class="section-title text-default" style="visibility: visible;">Наши контакты: </h3>
        <div class="contact__phone">
            <p class="font-default-bold">+7 (707) 617 22 94</p>
        </div>
        <div class="contact__email">
            <p class="font-default-bold">Email: example@mail.ru</p>
            <p class="font-default-bold">web@auto-lavka.kz</p>
        </div>
    </div>
</footer>

</@main.renderWith>