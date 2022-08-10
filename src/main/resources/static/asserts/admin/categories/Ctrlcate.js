app.controller("Ctrlcate", function ($scope, $http) {
    $scope.category = [];
    $scope.cate = {};
    $scope.items = [];

    $scope.getall = function () {
        $http.get("/rest/categories").then(resp => {
            $scope.category = resp.data;
            $scope.category.forEach(cates => {
                console.log(cates);
            })
        });
        $http.get("/rest/users").then(resp => {
            $scope.items = resp.data;
        });

    }

    $scope.getall();

    $scope.onSubmitForm = function (event) {
        event.preventDefault();

    }



    $scope.edit = function (cates) {
        $scope.cate = angular.copy(cates);


    }


    $scope.reset = function () {
        $scope.cate = {

        }
    }

    $scope.create = function () {

        var cates = angular.copy($scope.cate);
        $http.post('/rest/categories', cates).then(resp => {
            $scope.category.push(resp);
            Swal.fire(
                'Good job!',
                'Thêm danh mục thành công!',
                'success'
            )
            $scope.reset();
            $scope.getall();


        }).catch(error => {
            alert('thêm mới lỗi');
            console.log('lỗi', error);
        })
    }




    $scope.update = function () {
        var item = angular.copy($scope.cate);

        $http.put('/rest/categories/${item.id}', item).then(resp => {
            console.log(item, item.id)
            var index = $scope.category.findIndex(c => c.id == item.id);
            $scope.category[index] = item;
            $scope.reset();
             Swal.fire(
                'Good job!',
                'cập nhật danh mục thành công!',
                'success'
            )
            $scope.getall();
           
        }).catch(error => {
            alert('cập nhật  lỗi');
            console.log('lỗi', error);
        })
    }


    $scope.delete = function (cates) {
        console.log('đây là id ', cates.id)
        $http.delete('/rest/categories/' + cates.id).then(resp => {
            var index = $scope.category.findIndex(c => c.id == cates.id);
            $scope.category.splice(index, 1);
            $scope.reset();
            $scope.getall();
            alert('xóa danh mục thành công')

        })
            .catch(error => {
                alert('xóa dữ liệu lỗi');
                console.log('lỗi', error);
            })

    }








})