function solve(){
    const object = arguments[0];

    const method = ['GET','POST','DELETE','CONNECT'];
    const version = ['HTTP/0.9','HTTP/1.0','HTTP/1.1','HTTP/2.0'];


    if(!method.includes(object.method) || object.method == undefined){
        throw new Error('Invalid request header: Invalid Method');
    }

    const uriRegexPattern = /^[A-z.*0-9]+$/;

    if(object.uri == '' || !uriRegexPattern.test(object.uri)|| object.uri == undefined){
        throw new Error('Invalid request header: Invalid URI');
    }

    if(!version.includes(object.version || object.version == undefined)){
        throw new Error('Invalid request header: Invalid Version');
    }

    const messageRegex = /[<>&\\'"]/;

    if(messageRegex.test(object.message) || object.message == undefined){
        throw new Error('Invalid request header: Invalid Message');
    }

    return object;
}

console.log(solve ({
    method: 'GET',
    version: 'HTTP/1.1',
    uri: '.',
    message: 'rm -rf /*'
  }
  ));