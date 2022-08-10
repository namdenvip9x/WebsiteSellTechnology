var app = angular.module("shoping-cart", []);

app.controller("shoping-ctrl", function ($scope, $http) {


	$scope.cart = {
		items: [],

		add(id) {
			var item = this.items.find(item => item.id == id);
			if (item) {
				Swal.fire(
					'error',
					'San pham da co trong giỏ hàng',
					'error'
				)
				this.saveToLocalStorage();
				
			} else {
				$http.get('/rest/products/' + id).then(resp => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
					Swal.fire(
						'Good job!',
						'Đã thêm vào giỏ hàng',
						'success'
					)


				})
			}
		},
		get count() {
			return this.items
				.map(item => item.qty)
				.reduce((total, qty) => total += qty, 0);
		},
		get amount() {
			return this.items
				.map(item => item.qty * item.price)
				.reduce((total, qty) => total += qty, 0);
		},
		saveToLocalStorage() {
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
			console.log(json)
		},

		loadLocalStorage() {
			var json = localStorage.getItem("cart");
			this.items = json ? JSON.parse(json) : [];
		},

		remove(id) {
			var index = this.items.findIndex(item => item.id = id)
			this.items.splice(index, 1)
			this.saveToLocalStorage();
			Swal.fire(
				'Good job!',
				'Đã xoa khoi  giỏ hàng',
				'success'
			)
		},
		clear() {
			this.items = [];
			this.saveToLocalStorage();
		}

	}
	$scope.cart.loadLocalStorage();

	


	$scope.order = {
		
		createdate: new Date,
		address: "",
		totalmoney: $scope.cart.amount,

		get orderDetails() {
			return $scope.cart.items.map(item => {
				return {
					products: { id: item.id },
					price: item.price,
					quantity: item.qty
				}
			});
		},
		
		pushing() {
			var order = angular.copy(this);
			$http.post("/rest/orders", order).then(resp => {
				
				console.log( resp.data.id);
				Swal.fire(
					'Good',
					'Đặt hàng thành công',
					'success'
				)
				$scope.cart.clear();
				
			}).catch(error => {
				Swal.fire(
					'error',
					'San pham da co trong giỏ hàng',
					'error'
				)
				console.log(error, error, resp.id);

			})
		}



	}




})