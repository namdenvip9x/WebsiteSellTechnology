app.controller("Ctrluser", function ($scope, $http) {
     $scope.items = [];
     $scope.user = {};


     $scope.getall = function () {
          $http.get("/rest/users").then(resp => {
               $scope.items = resp.data;
               $scope.items.forEach(item => {
                    console.log(item)
               })


          });
     }


     $scope.getall();

     $scope.onSubmitForm = function (event) {
          event.preventDefault();

     }



     $scope.edit = function (item) {
          $scope.user = angular.copy(item);


     }

     $scope.reset = function () {
          $scope.user = {
               gender: false
          }

     }

     $scope.create = function () {
          var item = angular.copy($scope.user);
          $http.post('/rest/users', item).then(resp => {
               
				
					 $scope.items.push(resp);
                     $scope.reset();
                     $scope.getall();
                     alert('thêm mới thành công')
				  
          }).catch(error => {
               alert('thêm mới lỗi');
               console.log('lỗi', error);


          })
     }

       $scope.createUsers = function () {
          var item = angular.copy($scope.user);
          $http.post('/rest/users', item).then(resp => {
               
				
					 $scope.items.push(resp);
                     $scope.reset();
                     $scope.getall();
				  
               
               location.href = "/security/login";
          }).catch(error => {
               alert('thêm mới lỗi');
               console.log('lỗi', error);


          })
     }


     $scope.delete = function (item) {	  
          console.log(item.acount)
          $http.delete('/rest/users/'+item.acount).then(resp => { 
               var index = $scope.items.findIndex(u => u.acount == item.acount);
               $scope.items.splice(index, 1);
               $scope.reset();
               $scope.getall();
               alert('đã xóa  tài khoản này');

          })
               .catch(error => {
                    alert('xóa dữ liệu lỗi');
                    console.log('lỗi', error);
               })
     }

     $scope.update = function () {
          var item = angular.copy($scope.user);
          $http.put('/rest/users/${item.acount}',item).then(resp => {
               var index = $scope.items.findIndex(u => u.id == item.id);
               $scope.items[index] = item;
               $scope.reset();
               $scope.getall();
               alert('cập nhật mới thành công');
          }).catch(error => {
               alert('cập nhật  lỗi');
               console.log('lỗi', error);
          })
     }





})