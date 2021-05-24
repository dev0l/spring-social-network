let delAccount = document.getElementById('delAccount')
$(delAccount).click(() => {
  if (confirm("Are you sure that you want to delete account?")) {
    alert("Account deleted")
    return true;
  } else {
    alert("Still here")
    return false;
  }
})

// var myModal = document.getElementById('exampleModal')
// var myInput = document.getElementById('myInput')

// myModal.addEventListener('shown.bs.modal', function () {
//   myInput.focus()
// })

// $('#exampleModal').on('show.bs.modal', function (event) {
//   let button = $(event.relatedTarget) // Button that triggered the modal
//   let recipient = button.data('whatever') // Extract info from data-* attributes
//   // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
//   // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
//   let modal = $(this)
//   modal.find('.modal-title').text('New message to ' + recipient)
//   modal.find('.modal-body input').val(recipient)
// })