
export function login(username, password) {
  console.log('abc')
  return new Promise((resolve, reject) => {
    resolve({ data: { token: 'sfdsfdslkfdsf' }})
  })
}

export function getInfo(token) {
  return new Promise((resolve, reject) => {
    resolve({ data: { roles: ['admin', 'editor'] }})
  })
}

export function logout() {
  return new Promise((resolve, reject) => {
    resolve()
  })
}
