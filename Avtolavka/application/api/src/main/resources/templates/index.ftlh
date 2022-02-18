<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Только CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Document</title>
</head>
<body>

<header class="header">
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-light">
        <div class="container">
            <a href="#" class="navbar-brand d-flex align-items-center text-dark">
                <strong>Главная</strong>
            </a>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Искать" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Искать</button>
            </form>
        </div>
    </nav>
</header>
<main>
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Товары с доставкой и оптимальной ценой!</h1>
            </div>
        </div>
    </section>
    <div class="container">
        <div class="title-control">
            <div class="sort">
                <form>
                    <label for="select_view">
                        <select name="view" id="select_view" required>
                            <option value="" hidden>Выбрать</option>
                            <option>По индексу</option>
                            <option>Пропустить</option>
                        </select>
                    </label>
                    <input type="submit" value="Отправить">
                </form>
            </div>
        </div>
        <br>
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-1 g-4 bg-light">
            <div class="col num_1">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <p class="card-text">Товар: Прокладка поддона картера</p>
                        <p class="card-text">Уникальный номер: 8200 641 648</p>
                        <p class="card-text">Количество: 1 шт</p>
                        <p class="card-text">Цена товара: 290 тг</p>
                    </div>
                </div>
            </div>
            <div class="col num_2">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <p class="card-text">Товар: Свеча зажигания</p>
                        <p class="card-text">Уникальный номер: 7700 500 168</p>
                        <p class="card-text">Количество: 1 шт</p>
                        <p class="card-text">Цена товара: 1 100 тг</p>
                    </div>
                </div>
            </div>
            <div class="col num_3">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <p class="card-text">Товар: Фильтр внутренней вентиляции</p>
                        <p class="card-text">Уникальный номер: 68 08 606</p>
                        <p class="card-text">Количество: 1 шт</p>
                        <p class="card-text">Цена товара: 5 480 тг</p>
                    </div>
                </div>
            </div>
            <div class="col num_4">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <p class="card-text">Товар: Ремень гидроусилителя</p>
                        <p class="card-text">Уникальный номер: MD 304887</p>
                        <p class="card-text">Количество: 1 шт</p>
                        <p class="card-text">Цена товара: 9 120 тг</p>
                    </div>
                </div>
            </div>
            <div class="col num_5">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <p class="card-text">Товар: Фильтр масляный</p>
                        <p class="card-text">Уникальный номер: 06A 115 561 B</p>
                        <p class="card-text">Количество: 1 шт</p>
                        <p class="card-text">Цена товара: 2 040 тг</p>
                    </div>
                </div>
            </div>
            <div class="col num_6">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <p class="card-text">Товар: Колодки тормозные, комплект, задние</p>
                        <p class="card-text">Уникальный номер: 8E0 698 451 L</p>
                        <p class="card-text">Количество: 1 шт</p>
                        <p class="card-text">Цена товара: 14 520 тг</p>
                    </div>
                </div>
            </div>
        </div>
        <br>
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
</body>
</html>
