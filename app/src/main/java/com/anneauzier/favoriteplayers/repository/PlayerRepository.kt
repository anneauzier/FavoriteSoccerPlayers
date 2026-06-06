package com.anneauzier.favoriteplayers.repository

// centralizatodo o acesso a dados.
// intermediário entre o banco e a view model. O view model nunca fala com o dao diretamente, sempre passa pelo repository.
// isso facilita em mudancas. adicinar uma api remota sem mexer na view model.