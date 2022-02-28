$(document).ready(function (){

    function handleOrderDetails(response) {
        $('#orderDetailsModalTitle').empty()
        $('#orderDetailsModal').find('.modal-body').empty()
        $('#orderDetailsModalTitle').text(`Заявка №${response.order.id}`)
        let orderDetails = $(`
            <p>Имя клиента: ${response.order.client.name}</p>
            <p>Дата создания: ${response.order.dateCreation}</p>
            <p>Товары:</p>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Название</th>
                        <th scope="col">Количество</th>
                        <th scope="col">Цена продажи</th>
                        <th scope="col">В наличий</th>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>`)

        for (let i = 0; i < response.orderProducts.length; i++) {
            orderDetails.find('tbody').append($(`
            <tr>
                <th scope="row">${response.orderProducts[i].id}</th>
                <td>${response.orderProducts[i].product.name}</td>
                <td>${response.orderProducts[i].quantity}</td>
                <td>${response.orderProducts[i].product.sellingPrice}</td>
                <td>${response.orderProducts[i].product.inStock?"Да":"Нет"}</td>
            </tr>`))
        }
        $('#orderDetailsModal').find('.modal-body').append(orderDetails)
    }

    $('.order_card').click(function (){
        let orderId = $(this).find('.order_card_id').text()
        $.ajax({
            method: "GET",
            url: "http://localhost:8500/api/orders/"+orderId,
            success: (response) => {
                handleOrderDetails(response)
            },
            error: (error) => {
                console.log(error)
            }
        })
    })

    function handleClients(response) {
        $('.client_names_wrapper').empty()

        if (response.length != 0) {
            $('.client_names_wrapper').append($('<h5 class="mb-2">Выберите клиента:</h5>'))
            response.map(i => {
                console.log(response)
                let client_item = $(`<div class="client_item">
                    <input type="hidden" value="${i.id}"/>
                    <h5>${i.name}</h5>
                </div>`)
                client_item.click(function (){
                    $('.client_names_wrapper').empty()
                    $('#client_name').text(client_item.find('h5').text())
                    $('#client_name').append($(`<input type="hidden" value="${client_item.find('input').val()}" name="chosen_client_id" id="chosen_client_id" />`))
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
            url: `http://localhost:8500/api/clients?query=${query}`,
            success: (response) => {
                handleClients(response)
            },
            error: (error) => {
                alert(error)
            }
        })
    })
})