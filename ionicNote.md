# Toggle 1

```html
<ion-toggle ng-model="pushNotification.checked">
  Push Notifications
</ion-toggle>
```

```js
$scope.pushNotification = { checked: false };
```

# Toggle 2

```html
<ion-toggle toggle-class="toggle-assertive"
                    ng-model="emailNotification"
                    ng-true-value="'Subscribed'"
                    ng-false-value="'Unsubscribed'">
              Newsletter
</ion-toggle>
```

```js
$scope.emailNotification = 'Subscribed';
```

# Module name

```html
<html ng-app="ionicApp1">
```

```js
angular.module('ionicApp1', ['ionic'])...
```

# Conttroller name

```html
 <body ng-controller="MainCtrl">
```

```js
angular.module('ionicApp1', ['ionic'])
.controller('MainCtrl', function($scope) {}
```

# Preview json in html (bind data)

```html
<pre ng-bind="settingsList | json"></pre>
```

```js
$scope.settingsList = [
    { text: "Wireless", checked: true },
    { text: "GPS", checked: false },
    { text: "Bluetooth", checked: false }
  ];
```

# Confirm dialog

```html
<button class="button button-primary" ng-click="showConfirm()">Confirm</button>
```

```js
$scope.showConfirm = function() {
     var confirmPopup = $ionicPopup.confirm({
       title: 'Consume Ice Cream',
       template: 'Are you sure you want to eat this ice cream?'
     });
     confirmPopup.then(function(res) {
       if(res) {
         console.log('OK');
       } else {
         console.log('Cancel');
       }
     });
   };
```

# Custom dialog

```html
<button class="button button-dark" ng-click="showPopup()">show</button>
```

```js
var myPopup = $ionicPopup.show({
     template: '<input type="password" ng-model="data.wifi">',
     title: 'Enter Wi-Fi Password',
     subTitle: 'Please use normal things',
     scope: $scope,
     buttons: [
       { text: 'Cancel' },
       {
         text: '<b>Save</b>',
         type: 'button-positive',
         onTap: function(e) {
           if (!$scope.data.wifi) {
             //don't allow the user to close unless he enters wifi password
             e.preventDefault();
           } else {
             // return string pasword entered.
             return $scope.data.wifi;
           }
         }
       },
     ]
   });
   myPopup.then(function(res) {
     console.log('Tapped!', res);
   });
```

# List

```html
<ion-content>
      <!-- The list directive is great, but be sure to also checkout the collection repeat directive when scrolling through large lists -->

      <!-- show-delete,show-reorder: bool | to show delete/reorder button | if reorder true option button will not show -->
      <ion-list show-delete="data.showDelete" show-reorder="data.showReorder">

      <!-- forearch -->
        <ion-item ng-repeat="item1 in items"
                  item="item1"
                  href="#/item/{{item.id}}" class="item-remove-animate">
          Item {{ item1.id }}
          <ion-delete-button class="ion-minus-circled"
                             ng-click="onItemDelete(item1)">
          </ion-delete-button>
          <ion-option-button class="button-assertive"
                             ng-click="edit(item1)">
            Delete
          </ion-option-button>
          <ion-option-button class="button-calm"
                             ng-click="share(item1)">
            Share
          </ion-option-button>
          <ion-reorder-button class="ion-navicon" on-reorder="moveItem(item1, $fromIndex, $toIndex)"></ion-reorder-button>
        </ion-item>
      </ion-list>
    </ion-content>
```

```js
$scope.data = {
    showDelete: false
  };

  $scope.edit = function(item) {
    alert('Edit Item: ' + item.id);
  };
  $scope.share = function(item) {
    alert('Share Item: ' + item.id);
  };

  $scope.moveItem = function(item, fromIndex, toIndex) {
    $scope.items.splice(fromIndex, 1);
    $scope.items.splice(toIndex, 0, item);
  };

  $scope.onItemDelete = function(item) {
    $scope.items.splice($scope.items.indexOf(item), 1);
  };

  $scope.items = [
    { id: 0 },
    { id: 1 },
    { id: 2 },
    { id: 3 },
    { id: 4 },
    { id: 5 },
    { id: 6 },
    { id: 7 },
    { id: 8 },
    { id: 9 }
  ];
```

  <p data-height="244" data-theme-id="0" data-slug-hash="LNjvQX" data-default-tab="result" data-user="vuhung3990" class="codepen">See the Pen [List: Nightly](http://codepen.io/vuhung3990/pen/LNjvQX/) by Vũ Hùng ([@vuhung3990](http://codepen.io/vuhung3990)) on [CodePen](http://codepen.io).</p>
<script async src="//assets.codepen.io/assets/embed/ei.js"></script>

# Material progress

```html
<ion-spinner icon="android"></ion-spinner>
```

# Popover

```html
<!-- platform-ios, android,ionic -->
<body class="platform-ios" ng-controller="AppCtrl">
    <div class="bar bar-header">
      <h1 class="title">Popover</h1>
      <div class="buttons">
        <button class="button button-icon ion-more" ng-click="popover.show($event)">
        </button>
      </div>
    </div>
</body>
```

# Toolbar header auto hide

```html
<ion-pane>
      <ion-header-bar class="bar-positive">
        <div class="buttons">
          <button class="button button-icon ion-navicon"></button>
        </div>
        <h1 class="title">Things</h1>
      </ion-header-bar>

      <!-- important part -->
      <ion-content header-shrink scroll-event-interval="5">
      ............
      </ion-content>
</ion-pane>
```

# Checkbox

```html
<ion-checkbox>Push Notifications</ion-checkbox>
```

# Bottom sheet

```js
$scope.showActionsheet = function() {
    $ionicActionSheet.show({
      titleText: 'ActionSheet Example',
      buttons: [
        { text: '<i class="icon ion-share"></i> Share' },
        { text: '<i class="icon ion-arrow-move"></i> Move' },
      ],
      destructiveText: 'Delete',
      cancelText: 'Cancel',
      cancel: function() {
        console.log('CANCELLED');
      },
      buttonClicked: function(index) {
        console.log('BUTTON CLICKED', index);
        return true;
      },
      destructiveButtonClicked: function() {
        console.log('DESTRUCT');
        return true;
      }
    });
  };
```
