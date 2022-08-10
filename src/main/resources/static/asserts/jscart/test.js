var app = angular.module('cart-app', []);
app.controller('cart-ctrl', function ($scope, $http) {
    var urlProduct = `http://localhost:8080/rest/product`;
    var urlOrder = `http://localhost:8080/rest/order`;
    $scope.items = [];
    $scope.info = {};
    $scope.add = function (id) {
        $scope.item = $scope.items.find(it => it.id == id);
        $scope.item.qty++;
        $scope.saveLocalStorage();
    }
    $scope.counts = function () {
        return $scope.items
            .map(item => item.qty)
            .reduce((total, qty) => total + qty, 0);
    }
    $scope.amounts = function () {
        return $scope.items
            .map(item => item.qty * item.price)
            .reduce((total, qty) => total += qty, 0);
    }
    $scope.saveLocalStorage = function () {
        var json = JSON.stringify(angular.copy($scope.items));
        localStorage.setItem("cart", json);
    }
    $scope.loadLocalStorage = function () {
        var json = localStorage.getItem("cart");
        $scope.items = json ? JSON.parse(json) : [];
    }
    $scope.remove = function (id) {
        var index = $scope.items.findIndex(item => item.id == id)
        $scope.items.splice(index, 1);
        $scope.saveLocalStorage();
        location.reload();
    }
    $scope.refresh = function () {
        $scope.items = [];
        localStorage.clear();
    }
    $scope.buyCart = function () {
        const address = $scope.address;
        $scope.info = { 'address': address, 'total': $scope.amounts() };
        $http.post({ urlOrder } / cart, $scope.info).then(res => {
            $http.post(urlOrder, $scope.items).then(res => {
                $scope.refresh();
            })
        })
    }

    $scope.loadLocalStorage();
})