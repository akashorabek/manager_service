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
                        <th scope="col">Примечание</th>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>`)

        for (let i = 0; i < response.orderProducts.length; i++) {
            orderDetails.find('tbody').append($(`
            <tr>
                <th scope="row">${response.orderProducts[i].product.id}</th>
                <td>${response.orderProducts[i].product.name}</td>
                <td>${response.orderProducts[i].quantity}</td>
                <td>${response.orderProducts[i].product.sellingPrice}</td>
                <td>${response.orderProducts[i].product.inStock?"В наличии":"Под заказ"}</td>
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



})