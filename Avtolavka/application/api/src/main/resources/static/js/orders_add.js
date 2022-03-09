$(document).ready(function (){
    function handleClients(response) {
        $('.client_names_wrapper').empty()
        if (response.length != 0) {
            $('.client_names_wrapper').append($('<h5 class="mb-2">Выберите клиента:</h5>'))
            response.map(i => {
                let client_item = $(`<div class="client_item">
                    <input type="hidden" value="${i.id}"/>
                    <h5>${i.name}</h5>
                    <h6>${i.clientName}</h6>
                </div>`)
                client_item.click(function (){
                    $('#add_order_btn').attr('disabled', false)
                    $('.client_names_wrapper').empty()
                    $('#client_name').text(client_item.find('h5').text() + `(${i.clientName})`)
                    $('#client_name').append($(`<input type="hidden" value="${client_item.find('input').val()}" name="contact_id" id="chosen_client_id" />`))
                })
                $('.client_names_wrapper').append(client_item)
            })
        } else {
            $('.client_names_wrapper').append($('<div class="alert alert-primary" role="alert">Клиенты не найдены</div>'))
        }
    }

    $('#find_client_form').submit(function (e){
        e.preventDefault()
        let query = $('#clientInput').val();
        $.ajax({
            method: "GET",
            url: `http://localhost:8500/api/contacts/search?query=${query}`,
            success: (response) => {
                handleClients(response)
            },
            error: (error) => {
                alert(error)
            }
        })
    })

    function onProductItemRowClick() {
        $('.product_row_item').click(function (){
            if (!$(this).find('input').attr('checked')) {
                let product_item = $(`
               <tr>
                    <td class="order_product_item_id">${$(this).find('.product_row_item_id').text()}</td>
                    <td>${$(this).find('.product_row_item_name').text()}</td>
                    <td>${$(this).find('.product_row_item_price').text()}</td>
                    <td><input class="order_product_item_input form-control" type="number" value="${$(this).find('.product_row_item_quantity').text()}"></td>
                    <td><button class="delete_order_product_btn btn btn-danger"><span>&times;</span></button></td>
                </tr> 
            `)
                product_item.find('.delete_order_product_btn').click(function (){
                    let order_products = $('.order_add_right_products').children()
                    if (order_products.length > 0) {
                        for (let i = 0; i < order_products.length; i++) {
                            if ($(order_products[i]).find('.product_row_item_id').text() == product_item.find('.order_product_item_id').text()) {
                                $(order_products[i]).find('input').attr('checked', false)
                                $(order_products[i]).find('input').attr('disabled', false)
                            }
                        }
                    }
                    product_item.remove()
                })
                $('.order_add_left_products').append(product_item)
            }
            $(this).find('input').attr('checked', true)
            $(this).find('input').attr('disabled', true)
        })
    }

    function handleProducts(response) {
        $('.order_add_right_products').empty()
        let order_products = $('.order_add_left_products').children()
        response.map(product => {
            let product_item = $(`
                <tr class="product_row_item">
                    <td class="product_row_item_id">${product.id}</td>
                    <td class="product_row_item_name">${product.name}</td>
                    <td class="product_row_item_price">${product.price}</td>
                    <td class="product_row_item_quantity">${product.quantity}</td>
                    <td>${product.inStock?"В наличии":"Под заказ"}</td>
                    <td><input type="checkbox" value="${product.id}" class="form-check-input product_checkbox"></td>
                </tr>
            `)
            if (order_products.length > 0) {
                for (let i = 0; i < order_products.length; i++) {
                    if ($(order_products[i]).find('.order_product_item_id').text() == product_item.find('.product_row_item_id').text()) {
                        product_item.find('input').attr('checked', true)
                        product_item.find('input').attr('disabled', true)
                    }
                }
            }
            $('.order_add_right_products').append(product_item)
        })
        onProductItemRowClick()
    }



    function getProducts(query = null) {
        let url = 'http://localhost:8500/api/products'
        if (query != null) {
            url = url + '?query=' + query
        }
        $.ajax({
            method: "GET",
            url: url,
            success: (response) => {
                handleProducts(response)
            },
            error: (error) => {
                alert(error)
            }
        })
    }

    getProducts()

    $('#find_product_form').submit(function (e){
        e.preventDefault()
        let query = $('#productInput').val();
        getProducts(query)
    })

    $('.add_order_form').submit(function (e){
        e.preventDefault()
        let clientId = $('#client_name').find('input').val()
        let products = $('.order_add_left_products').children()
        if (products.length != 0) {
            let productIds = [];
            let quantities = [];
            for(let i = 0; i < products.length; i++) {
                productIds[i] = $(products[i]).find('.order_product_item_id').text()
                quantities[i] = $(products[i]).find('input').val()
            }
            $.ajax({
                method: "POST",
                url: 'http://localhost:8500/orders/add',
                data: {
                    contactId: clientId,
                    productIds: productIds,
                    quantities: quantities
                },
                success: (response) => {
                    window.location = "http://localhost:8500/orders";
                },
                error: (error) => {
                    alert(error)
                }
            })
        } else {
            alert("Добавьте минимум 1 продукт чтобы сохранить КП.")
        }
    })

})