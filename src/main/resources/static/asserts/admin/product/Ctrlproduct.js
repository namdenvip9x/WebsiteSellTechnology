app.controller("Ctrlproduct", function ($scope, $http) {
    $scope.items = [];
    $scope.product = {};
    $scope.cates = [];



    $scope.getall = function () {
        $http.get("/rest/products").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                console.log(item)
            })


        });

        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;

        });



    }


    $scope.getall();

    $scope.onSubmitForm = function (event) {
        event.preventDefault();

    }



    $scope.edit = function (item) {

        $scope.product = angular.copy(item);


    }

    $scope.reset = function () {
        $scope.product = {
            images: 'bn1.png',
            status: false
        }

    }


    $scope.create = function () {
        if (confirm("bạn có muốn  thêm tài khoản  ?") == true) {
            var p = angular.copy($scope.product);
            $http.post('/rest/products', p).then(resp => {
                $scope.items.push(resp.data);
                $scope.reset();
                $scope.getall();
                Swal.fire(
                    'Good job!',
                    'Đã thêm sản phẩm thành công',
                    'success'
                )

            }).catch(error => {
                alert('thêm mới lỗi');
                console.log('lỗi', error);
            })

        } else {
            Swal.fire(
                'error!',
                'xác nhận không thêm sản phẩm',
                'error'
            )
        }

    }


    $scope.delete = function (item) {
        if (confirm("bạn có muốn xóa sản phẩm ?") == true) {
            console.log(item.acount)
            $http.delete('/rest/products/' + item.id).then(resp => {
                var index = $scope.items.findIndex(u => u.id == item.id);
                $scope.items.splice(index, 1);
                $scope.reset();
                $scope.getall();
                Swal.fire(
                    'Good',
                    'Đã xóa sản phẩm',
                    'success'
                )

            })
                .catch(error => {
                    alert('xóa dữ liệu lỗi');
                    console.log('lỗi', error);
                })
        }
        else { }

    }

    $scope.update = function () {
        var item = angular.copy($scope.product);
        $http.put('/rest/products/' + item.id, item).then(resp => {
            var index = $scope.items.findIndex(u => u.id == item.id);
            $scope.items[index] = item;
            $scope.reset();
            $scope.getall();
            Swal.fire(
                'Good',
                'Đã cập nhật sản phẩm',
                'success'
            )
        }).catch(error => {
            alert('cập nhật  lỗi');
            console.log('lỗi', error);
        })
    }

    $scope.imageChanged = function (files) {

        var data = new FormData();
        data.append('file', files[0]);

        $http.post('/rest/upload/img', data, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.product.images = resp.data.name;
            Swal.fire(
                'Good',
                'Đã chọn ảnh sản phẩm',
                'success'
            )
        }).catch(error => {
            alert('lỗi upload ')
            console.log(error);
        })

    }




})