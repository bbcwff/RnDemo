import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Alert,
  NativeModules
} from 'react-native';

class HelloWorld extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.hello} onPress={() => showAlert()}>Hello, World</Text>
      </View>
    );
  }
}

function showAlert() {
  // let systemN=NativeModules.TestModule.systemN;
  // Alert.alert(systemN);

  console.log(NativeModules)
  NativeModules.TestExample.show('Awesome', NativeModules.ToastExample.SHORT);
}

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center'
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10
  }
});


AppRegistry.registerComponent(
  'MyReactNativeApp',
  () => HelloWorld
);

AppRegistry.getRegistry(['TestExample'])


console.log('AppRegistry', AppRegistry.getRegistry());