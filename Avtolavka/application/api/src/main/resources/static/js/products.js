$(document).ready(function (){

    function handleProductDetails(response) {
        $('#productDetailsModalTitle').empty()
        $('#productDetailsModal').find('.modal-body').empty()
        $('#productDetailsModalTitle').text(`Товар №${response.id}`)
        let productDetails = $(`
            <p>Название: ${response.name}</p>
            <p>Цена: ${response.price}</p>
            <p>Количество: ${response.quantity}</p>
            <p>Примечание: ${response.inStock?"В наличии":"Под заказ"}</p>
           `)
        $('#productDetailsModal').find('.modal-body').append(productDetails)
    }

    $('.product_tr').click(function (){
        let productId = $(this).find('.product_tr_id').text()
        $.ajax({
            method: "GET",
            url: "http://localhost:8500/api/products/"+productId,
            success: (response) => {
                handleProductDetails(response)
            },
            error: (error) => {
                console.log(error)
            }
        })
    })
})